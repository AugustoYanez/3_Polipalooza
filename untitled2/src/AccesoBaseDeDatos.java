
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

    public AccesoBaseDeDatos(String nombreBaseDeDatos, List<String> nombreTabla) {
        this.nombreBaseDeDatos = nombreBaseDeDatos;
        this.nombreTabla = nombreTabla;
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

    public ArrayList<String> obtenerColumnasDeUnaTabla(String nombreTabla) {
        String consulta = "SHOW COLUMNS FROM " + nombreTabla;
        ArrayList<String> nombreCampos = new ArrayList<>();
        try {
            ResultSet data;
            PreparedStatement sentenciaSQL = conexion.prepareStatement(consulta);
            data = sentenciaSQL.executeQuery(consulta);
            while (data.next() == true) {
                nombreCampos.add(data.getString("Field"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreCampos;
    }
    public void artistaDestacadoEscenario(){
        String sql = "SELECT pr.escenario_id, p.nombre AS nombre_artista " +
                "FROM Presentaciones pr " +
                "JOIN Artistas a ON pr.artista_id = a.artista_id " +
                "JOIN Personas p ON a.persona_id = p.persona_id " +
                "WHERE a.es_destacado = 1 " +
                "ORDER BY pr.escenario_id";
        ResultSet data;
        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            data = sentencia.executeQuery(sql);
            while (data.next()) {
                int escenarioId = data.getInt("escenario_id");
                String nombreArtista = data.getString("nombre_artista");
                System.out.println("Escenario ID: " + escenarioId + ", Artista: " + nombreArtista);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public HashMap<Integer,HashMap<String,Object>> obtenerDatosArtista(){
        ResultSet data;
        ArrayList<String> nombres = obtenerColumnasDeUnaTabla("Artistas");
        HashMap<Integer,HashMap<String,Object>>  valores=new HashMap<Integer,HashMap<String,Object>>();
        String consulta= "select Personas.persona_id,nombre,apellido,fecha_nacimiento,celular,genero_musical,es_destacado from Personas inner join Artistas ON Personas.persona_id=Artistas.artista_id;";
        System.out.println(consulta);
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(consulta);
            data = sentenciaSQL.executeQuery(consulta);
            while (data.next() == true) {
                HashMap<String,Object>aux = new HashMap<String,Object>();
                aux.put(nombres.get(1),data.getString(nombres.get(1)));
                aux.put(nombres.get(2),data.getString(nombres.get(2)));
                aux.put(nombres.get(3),data.getDate(nombres.get(3)));
                aux.put(nombres.get(4),data.getString(nombres.get(4)));
                aux.put(nombres.get(5),data.getString(nombres.get(5)));
                aux.put(nombres.get(6),data.getBoolean(nombres.get(6)));
                valores.put(data.getInt(nombres.get(0)),aux);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valores;
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

    public void escenarioPersonalInsuficiente(){
        ResultSet data;
        String sqlEscenariosPersonalInsuficiente = "SELECT Escenarios.escenario_id, Escenarios.nombre " +
                "FROM Escenarios " +
                "LEFT JOIN ProduccionEscenarios ON Escenarios.escenario_id = ProduccionEscenarios.escenario_id " +
                "LEFT JOIN PersonalProduccion ON ProduccionEscenarios.personal_id = PersonalProduccion.personal_id " +
                "GROUP BY Escenarios.escenario_id, Escenarios.nombre " +
                "HAVING COUNT(DISTINCT PersonalProduccion.personal_id) < 3 OR COUNT(DISTINCT PersonalProduccion.personal_id) IS NULL";

        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(sqlEscenariosPersonalInsuficiente);
            data = sentenciaSQL.executeQuery(sqlEscenariosPersonalInsuficiente);
            while (data.next()) {
                int escenarioId = data.getInt("escenario_id");
                String nombreEscenario = data.getString("nombre");
                System.out.println("Escenario ID: " + escenarioId + ", Nombre: " + nombreEscenario);}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ar(){
        String sql = "SELECT pr.escenario_id, a.genero_musical " +
                "FROM Presentaciones pr " +
                "JOIN Artistas a ON pr.artista_id = a.artista_id " +
                "GROUP BY pr.escenario_id, a.genero_musical " +
                "ORDER BY pr.escenario_id";
        ResultSet data;

        try{
            PreparedStatement sentenciaSQL = conexion.prepareStatement(sql);
            data = sentenciaSQL.executeQuery(sql);
            int escenarioActual = 0;
            while (data.next()) {
                int escenarioId = data.getInt("escenario_id");
                String generoMusical = data.getString("genero_musical");

                if (escenarioId != escenarioActual) {
                    System.out.println("Escenario ID: " + escenarioId);
                    escenarioActual = escenarioId;
                }

                System.out.println("Género musical: " + generoMusical);
            }
            System.out.println();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public void ar1(){
        String sql = "SELECT e.nombre" +"\n" +
                "FROM Escenarios e" +"\n" +
                "JOIN Presentaciones p ON e.escenario_id = p.escenario_id " +"\n" +
                " WHERE p.horario_fin = (SELECT MAX(horario_fin) FROM Presentaciones);";
        ResultSet data;

        try{
            PreparedStatement sentenciaSQL = conexion.prepareStatement(sql);
            data = sentenciaSQL.executeQuery(sql);
            while (data.next()) {
                if (data.next()) {
                    String nombreEscenario = data.getString("nombre");
                    System.out.println("Escenario: " + nombreEscenario);
                }}
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void artistasRepetidos(){
        ResultSet data;
        String sqlArtistasRepetidos = "SELECT p.nombre AS nombre_persona " +
                "FROM Presentaciones pr " +
                "JOIN Artistas a ON pr.artista_id = a.artista_id " +
                "JOIN Personas p ON a.persona_id = p.persona_id " +
                "GROUP BY a.persona_id " +
                "HAVING COUNT(DISTINCT pr.escenario_id) > 1";
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(sqlArtistasRepetidos);
            data = sentenciaSQL.executeQuery(sqlArtistasRepetidos);
            while (data.next()) {
                String nombrePersona = data.getString("nombre_persona");
                System.out.println("Nombre: " + nombrePersona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void personalRepetido(){
        ResultSet data;
        String sqlPersonalRepetido = "SELECT pp.personal_id " +
                "FROM ProduccionEscenarios pe " +
                "JOIN PersonalProduccion pp ON pe.personal_id = pp.personal_id " +
                "GROUP BY pe.personal_id " +
                "HAVING COUNT(DISTINCT pe.escenario_id) > 1";
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(sqlPersonalRepetido);
            data = sentenciaSQL.executeQuery(sqlPersonalRepetido);
            while (data.next()) {
                int personalId = data.getInt("personal_id");
                System.out.println("ID: " + personalId );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public HashMap<Integer, HashMap<String, Object>> cargarEscenarios(){
        HashMap<Integer, HashMap<String, Object>> escenarios = new HashMap<>();
        ResultSet data;
        String sql = "select * from Escenarios;";
        try{
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            data = sentencia.executeQuery(sql);
            while(data.next()){
                int id = data.getInt("escenario_id");
                HashMap<String, Object> e = new HashMap<>();
                e.put("nombre", data.getInt("nombre"));
                e.put("capacidad_maxima", data.getInt("capacidad_maxima"));
                escenarios.put(id, e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return escenarios;
    }
    public HashMap<Artistas, ArrayList<Date>> cargarPresentacion(int id){
        ResultSet data;
        String sql = "call Polipalooza.cargarPresentaciones(" + id + ");";
        HashMap <Artistas, ArrayList<Date>> presentaciones = new HashMap<Artistas, ArrayList<Date>>();
        try{
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            data = sentencia.executeQuery(sql);
           while(data.next()){
               Artistas a = new Artistas(data.getString("nombre"), data.getString("genero_musical"), data.getBoolean("es_destacado"), null);
               ArrayList<Date> horario = new ArrayList<>();
               horario.add(data.getDate("horario_inicio"));
               horario.add(data.getDate("horario_fin"));
               presentaciones.put(a, horario);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return presentaciones;
    }
    /**   public HashSet<PersonalProduccion> cargarPersonal(){
        HashSet<PersonalProduccion> personalProduccion = new HashSet<>();
        ResultSet data;
        String sql = "select PersonalProduccion.personal_id, Personas.nombre, nombreRol from Personas\n" +
                "join PersonalProduccion on Personas.persona_id = PersonalProduccion.persona_id\n" +
                "join roles on rol = roles_rol;";
        try{
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            data = sentencia.executeQuery(sql);
            while(data.next()){
                PersonalProduccion a = new PersonalProduccion(data.getInt("personal_id"), data.getString("nombreRol"));
                personalProduccion.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personalProduccion;
    }



    public HashSet<PersonalProduccion> cargarPersonalEscenario(int id){
        HashSet<PersonalProduccion> personalProduccion = new HashSet<>();
        ResultSet data;
        String sql = "call Polipalooza.escenarioPersonal(" + id + ");";
        try{
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            data = sentencia.executeQuery(sql);
            while(data.next()){
                PersonalProduccion a = new PersonalProduccion(data.getInt("personal_id"), data.getString("nombreRol"));
                personalProduccion.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personalProduccion;
    }
    **/


// 1 rnombreRol ro1

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
        String sql = "select Artistas.artista_id, nombre, horario_inicio, horario_fin, genero_musical, es_destacado from Presentaciones join Artistas on Artistas.artista_id = Presentaciones.artista_id join Personas on Artistas.persona_id = Personas.persona_id where escenario_id = " + id + ";";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sql);
            data = sentencia.executeQuery(sql);

            while ( data.next()){
                HashMap<String,Object> aux = new HashMap<>();
                aux.put("nombre",data.getString("nombre"));
                aux.put("horario_inicio",data.getDate("horario_inicio"));
                aux.put("horario_fin",data.getDate("horario_fin"));
                aux.put("genero_musical",data.getString("genero_musical"));
                aux.put("es_destacado",data.getString("es_destacado"));
                valores.put(data.getInt("artista_id"),aux);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return valores;
    }
}