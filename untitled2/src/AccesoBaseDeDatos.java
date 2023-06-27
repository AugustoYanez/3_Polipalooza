
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

    public HashMap<String, Object> almacenarDatos(Object... datos) {
        HashMap<String, Object> datosNuevos = new HashMap<>();
        for (int i = 0; i < datos.length; i = i + 2) {
            datosNuevos.put((String) datos[i], datos[i + 1]);
        }
        return datosNuevos;
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

    public int obtenerId(String nombreTabla, String atributo, Object valor) {
        int id = 0;
        ResultSet data ;
        String atributoPK= obtenerColumnasDeUnaTabla(nombreTabla).get(0);
        String consulta = "SELECT "+ atributoPK+ " FROM " + nombreTabla + " where " + atributo + " = " + "\"" + valor + "\"";
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(consulta);
            data = sentenciaSQL.executeQuery(consulta);
            while (data.next() == true) {
                id=data.getInt(atributoPK);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public ArrayList<String> obtenerSelectConMasDeUnValor(String nombreTabla, String nombreCampo,String columnaTabla,Object condicion){
        ResultSet data;
        ArrayList<String> valorCampo=new ArrayList<>();
        String consulta= "Select "+ nombreCampo+ " from " + nombreTabla+" where "+columnaTabla+"="+"\""+condicion+"\""+";";
        System.out.println(consulta);
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(consulta);
            data = sentenciaSQL.executeQuery(consulta);
            while (data.next() == true) {
                valorCampo.add(data.getString(nombreCampo));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valorCampo;
    }

    public boolean ifExists(String nombreTabla, String columnaTabla,Object condicion){
        ResultSet data;
        ArrayList<String> valorCampo=new ArrayList<>();
        boolean existe=true;
        String consulta= "Select * "+ " from " + nombreTabla+" where "+columnaTabla+"="+"\""+condicion+"\""+";";
        System.out.println(consulta);
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(consulta);
            data = sentenciaSQL.executeQuery(consulta);
            while (data.next() == true) {

                // El campo Field es el que contiene el nombre
                // de la columna

                valorCampo.add(data.getString(columnaTabla));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (valorCampo.size()!=0){

        }else{
            existe=false;

        }
        return existe;
    }


    public String obtenerValorDeUnCampo(String nombreTabla, String nombreCampo, int id){
        ResultSet data;
        String valorCampo=null;
        String columnaId=obtenerColumnasDeUnaTabla(nombreTabla).get(0);
        String consulta= "Select "+ nombreCampo+ " from " + nombreTabla+" where "+columnaId+"="+id+";";
        System.out.println(consulta);
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(consulta);
            data = sentenciaSQL.executeQuery(consulta);
            while (data.next() == true) {
                // El campo Field es el que contiene el nombre
                // de la columna
                valorCampo=data.getString(nombreCampo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valorCampo;
    }
    public void actualizarVecesSolicitada(String nombreTabla, String nombreCampo, int id){
        int valorCampoPrevio= Integer.parseInt(obtenerValorDeUnCampo(nombreTabla,nombreCampo, id));
        String columnaId=obtenerColumnasDeUnaTabla(nombreTabla).get(0);
        String consulta= "Update "+nombreTabla+" set " + nombreCampo+ "=" +valorCampoPrevio + "+1"+ " where " + columnaId + "=" +id+";";
        System.out.println(consulta);

        try{
            PreparedStatement sentenciaSQL=conexion.prepareStatement(consulta);
            int result=sentenciaSQL.executeUpdate();

            if(result>0){
                System.out.println("Actualizacion hecha");
            }
            else{
                System.out.println("Fallo actualizacion");
            }

            sentenciaSQL.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void actualizarEstado(String nombreTabla, String nombreCampo, int id){
        String valorCampoPrevio= (obtenerValorDeUnCampo(nombreTabla,nombreCampo, id)).toUpperCase();
        String columnaId=obtenerColumnasDeUnaTabla(nombreTabla).get(0);
        boolean estadoQueHayQueponer=true;
        if(valorCampoPrevio.equals("1")){
            estadoQueHayQueponer=false;
        }
        String consulta= "Update "+nombreTabla+" set " + nombreCampo+ "=" + estadoQueHayQueponer + " where " + columnaId + "=" +id+";";
        System.out.println(consulta);

        try{
            PreparedStatement sentenciaSQL=conexion.prepareStatement(consulta);
            int result=sentenciaSQL.executeUpdate();

            if(result>0){
                System.out.println("Actualizacion hecha");
            }
            else{
                System.out.println("Fallo actualizacion");
            }

            sentenciaSQL.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int obtenerValorMaximo(String nombreTabla, String nombreColumna){
        int id = 0;
        ResultSet data ;
        String consulta = "SELECT max("+ nombreColumna+ ") FROM " + nombreTabla+ ";" ;

        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(consulta);
            data = sentenciaSQL.executeQuery(consulta);
            while (data.next() == true) {

                id=data.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    public void ingresarDatos(HashMap<String, Object> valores, String nombreTabla){
        ArrayList<String> columnasTablaUsuario= obtenerColumnasDeUnaTabla(nombreTabla);
        String consulta = "Insert into " + nombreTabla + " values ( ";
        for (int i = 0; i <columnasTablaUsuario.size() ; i++) {
            String nombreColumna=columnasTablaUsuario.get(i);
            Object datoIngresado=valores.get(nombreColumna);
            if(datoIngresado.getClass().getSimpleName().equals("Boolean") || datoIngresado.getClass().getSimpleName().equals("Integer")  || datoIngresado.getClass().getSimpleName().equals("Double")){
                consulta=consulta+datoIngresado;
            }
            else {
                consulta = consulta + "\"" + datoIngresado + "\"";
            }
            if(i<columnasTablaUsuario.size()-1){
                consulta=consulta+ ", ";
            }
            if(i==columnasTablaUsuario.size()-1){
                consulta=consulta+");";
            }
        }
        System.out.println(consulta);
        try{
            PreparedStatement sentenciaSQL=conexion.prepareStatement(consulta);
            int result=sentenciaSQL.executeUpdate();

            if(result>0){
                System.out.println("Insercion hecha");
            }
            else{
                System.out.println("Fallo");
            }

            sentenciaSQL.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public HashSet<Artistas> obtenerDatosArtista(){
        ResultSet data;
        HashSet<Artistas>  artistas=new HashSet<Artistas>();
        String consulta= "select Personas.persona_id,nombre,apellido,fecha_nacimiento,celular,genero_musical,es_destacado from Personas inner join Artistas ON Personas.persona_id=Artistas.artista_id;";
        System.out.println(consulta);
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(consulta);
            data = sentenciaSQL.executeQuery(consulta);
            while (data.next() == true) {
                Artistas a= new Artistas(data.getInt("persona_id"),data.getString("nombre"),data.getString("apellido"), LocalDate.parse(data.getString("fecha_nacimiento")),data.getString("celular"),data.getString("genero_musical"),data.getBoolean("es_destacado"));
                artistas.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return artistas;
    }

    public void artistaPorEscenario(){
        ResultSet data;
        // Lista de artistas por escenario
        String sqlListaArtistas = "SELECT pr.escenario_id, p.nombre AS nombre_artista " +
                "FROM Presentaciones pr " +
                "JOIN Artistas a ON pr.artista_id = a.artista_id " +
                "JOIN Personas p ON a.persona_id = p.persona_id " +
                "ORDER BY pr.escenario_id";
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(sqlListaArtistas);
            data = sentenciaSQL.executeQuery(sqlListaArtistas);
            while (data.next()) {
                int escenarioId = data.getInt("escenario_id");
                String nombreArtista = data.getString("nombre_artista");
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
            System.out.println("e. ARTISTAS QUE NO CUMPLEN LA REGLA DE TOCAR EN UN SOLO ESCENARIO: \n");
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
        System.out.println("e. PERSONALES DE PRODUCCION QUE NO CUMPLEN LA REGLA DE TRABAJAR EN UN SOLO ESCENARIO: \n");
        try {
            PreparedStatement sentenciaSQL = conexion.prepareStatement(sqlPersonalRepetido);
            data = sentenciaSQL.executeQuery(sqlPersonalRepetido);
            System.out.println("e. PERSONALES DE PRODUCCION QUE NO CUMPLEN LA REGLA DE TRABAJAR EN UN SOLO ESCENARIO: \n");
            while (data.next()) {
                int personalId = data.getInt("personal_id");
                System.out.println("ID: " + personalId );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}