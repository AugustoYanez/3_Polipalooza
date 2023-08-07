
import javax.xml.ws.Response;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AccesoBaseDeDatos {

    private Connection conexion;
    private String nombreBaseDeDatos;
    private List<String> nombreTabla;

    public AccesoBaseDeDatos(String nombreBaseDeDatos, List<String> nombreTabla, String user, String password) {
        this.nombreBaseDeDatos = nombreBaseDeDatos;
        this.nombreTabla = nombreTabla;
        try {
            this.conectar(user, password);
        }catch (SQLException er){
            System.out.println(er);
        }
    }

    public void conectar(String user, String password) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/"+nombreBaseDeDatos;
        try {
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion != null) {
                System.out.println("Se ha conectado exitósamente a la base de datos");
            } else {
                System.out.println("No se ha podido conectar a la base de datos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    //cargar Datos de Sql a Java
    public HashMap<Integer,HashMap<String,Object>> cargarPersonal1 (int id){

        HashMap<Integer,HashMap<String,Object>> valores = new HashMap<>();
        ResultSet data;
        String sql;
        if (id == -1){
            sql = "select personal_id, nombreRol from PersonalProduccion join roles on roles_rol = rol;";
        }else{
            sql = "select PersonalProduccion.personal_id, nombreRol from ProduccionEscenarios join PersonalProduccion on ProduccionEscenarios.personal_id = PersonalProduccion.personal_id join roles on roles_rol = rol where escenario_id = " + id + ";";
        }

        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            data = sentencia.executeQuery(sql);

            while(data.next()){
                HashMap<String,Object> aux = new HashMap<>();
                aux.put("nombreRol",data.getString("nombreRol"));
                valores.put(data.getInt("personal_id"),aux);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return valores;
    }

  public HashMap<Integer,HashMap<String,Object>> cargarEscenario(){
      HashMap<Integer,HashMap<String,Object>> valores = new HashMap<>();
      ResultSet data;
      String sql = "select * from Escenarios;";

      PreparedStatement sentencia = null;
      try {
          sentencia = conexion.prepareStatement(sql);
          data = sentencia.executeQuery(sql);

          while ( data.next()){
              HashMap<String,Object> aux = new HashMap<>();
              aux.put("nombre",data.getString("nombre"));
              aux.put("capacidad_maxima",data.getInt("capacidad_maxima"));
              valores.put(data.getInt("escenario_id"),aux);
          }
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
      return valores;
  }
    public HashMap<Integer,HashMap<String,Object>> cargarPresentaciones(int id){
        HashMap<Integer,HashMap<String,Object>> valores = new HashMap<>();
        ResultSet data;
        String sql = "select Artistas.artista_id, nombre, fecha_nacimiento, horario_inicio, horario_fin, genero_musical, es_destacado from Presentaciones join Artistas on Artistas.artista_id = Presentaciones.artista_id join Personas on Artistas.persona_id = Personas.persona_id where escenario_id = " + id + ";";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sql);
            data = sentencia.executeQuery(sql);

            while ( data.next()){
                HashMap<String,Object> aux = new HashMap<>();
                aux.put("nombre",data.getString("nombre"));
                aux.put("fecha_nacimiento",data.getDate("fecha_nacimiento"));
                aux.put("horario_inicio",data.getString("horario_inicio"));
                aux.put("horario_fin",data.getString("horario_fin"));
                aux.put("genero_musical",data.getString("genero_musical"));
                aux.put("es_destacado",data.getBoolean("es_destacado"));
                valores.put(data.getInt("artista_id"),aux);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return valores;
    }
    public HashSet<Asistentes> obtenerDatosAsistentes(){ // llenar los asistenes con los datos de mysql
        ResultSet data;
        HashSet<Asistentes>  asistentes =new HashSet<Asistentes>();
        String consulta= "select nombre,es_vip,requerimiento_especial from Personas inner join Asistentes ON Personas.persona_id=Asistentes.asistente_id;";
        System.out.println(consulta);
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(consulta);
            data = sentenciaSQL.executeQuery(consulta);
            while (data.next() == true) {
                Asistentes a= new Asistentes(data.getString("nombre"),data.getBoolean("es_vip"),data.getString("requerimiento_especial"));
                asistentes.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return asistentes;
    }
    public void artistaPorEscenario(){
        ResultSet data;
        // Lista de artistas por escenario
        String sqlListaArtistas = "call Polipalooza.escenarioArtistas();";
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(sqlListaArtistas);
            data = sentenciaSQL.executeQuery(sqlListaArtistas);
            while (data.next()) {
                int escenarioId = data.getInt("escenario_id");
                String nombreArtista = data.getString("nombre");
                System.out.println("Escenario ID: " + escenarioId + ", Artista: " + nombreArtista);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void artistaMasJoven(){
        ResultSet data;
        String sqlArtistaMasJoven = "SELECT pr.escenario_id, p.nombre AS nombre_artista, p.fecha_nacimiento " +
                "FROM Presentaciones pr " +
                "JOIN Artistas a ON pr.artista_id = a.artista_id " +
                "JOIN Personas p ON a.persona_id = p.persona_id " +
                "WHERE p.fecha_nacimiento = (SELECT MAX(p2.fecha_nacimiento) " +
                "                            FROM Presentaciones pr2 " +
                "                            JOIN Artistas a2 ON pr2.artista_id = a2.artista_id " +
                "                            JOIN Personas p2 ON a2.persona_id = p2.persona_id " +
                "                            WHERE pr2.escenario_id = pr.escenario_id " +
                "                            ORDER BY p2.fecha_nacimiento ASC " +
                "                            LIMIT 1) " +
                "ORDER BY pr.escenario_id";
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(sqlArtistaMasJoven);
            data = sentenciaSQL.executeQuery(sqlArtistaMasJoven);
            while (data.next()) {
                int escenarioId = data.getInt("escenario_id");
                String nombreArtista = data.getString("nombre_artista");
                Date fechaNacimiento = data.getDate("fecha_nacimiento");
                System.out.println("Escenario ID: " + escenarioId + ", Artista: " + nombreArtista + ", Fecha de nacimiento: " + fechaNacimiento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}