import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/Polipalooza"; // Reemplaza con la URL de tu base de datos MySQL
        String usuario = "alumno"; // Reemplaza con tu usuario de MySQL
        String contraseña = "alumnoipm"; // Reemplaza con tu contraseña de MySQL

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer la conexión a la base de datos
            conn = DriverManager.getConnection(jdbcUrl, usuario, contraseña);

            // Lista de artistas por escenario
            String sqlListaArtistas = "SELECT pr.escenario_id, p.nombre AS nombre_artista " +
                    "FROM Presentaciones pr " +
                    "JOIN Artistas a ON pr.artista_id = a.artista_id " +
                    "JOIN Personas p ON a.persona_id = p.persona_id " +
                    "ORDER BY pr.escenario_id";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlListaArtistas);

            System.out.println(" a. LISTA DE ARTISTAS POR ESCENARIO: \n");
            while (rs.next()) {
                int escenarioId = rs.getInt("escenario_id");
                String nombreArtista = rs.getString("nombre_artista");
                System.out.println("Escenario ID: " + escenarioId + ", Artista: " + nombreArtista);
            }

            System.out.println();

            // Artista más joven por escenario
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

            rs = stmt.executeQuery(sqlArtistaMasJoven);

            System.out.println("b. ARTISTA MAS JOVEN POR ESCENARIO: \n");
            while (rs.next()) {
                int escenarioId = rs.getInt("escenario_id");
                String nombreArtista = rs.getString("nombre_artista");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                System.out.println("Escenario ID: " + escenarioId + ", Artista: " + nombreArtista + ", Fecha de nacimiento: " + fechaNacimiento);
            }

            System.out.println();

            // Escenarios con personal insuficiente
            String sqlEscenariosPersonalInsuficiente = "SELECT Escenarios.escenario_id, Escenarios.nombre " +
                    "FROM Escenarios " +
                    "LEFT JOIN ProduccionEscenarios ON Escenarios.escenario_id = ProduccionEscenarios.escenario_id " +
                    "LEFT JOIN PersonalProduccion ON ProduccionEscenarios.personal_id = PersonalProduccion.personal_id " +
                    "GROUP BY Escenarios.escenario_id, Escenarios.nombre " +
                    "HAVING COUNT(DISTINCT PersonalProduccion.personal_id) < 3 OR COUNT(DISTINCT PersonalProduccion.personal_id) IS NULL";

            rs = stmt.executeQuery(sqlEscenariosPersonalInsuficiente);

            System.out.println("c. ESCENARIOS QUE NO CUMPLEN CON EL PERSONAL DE PRODUCCION MINIMO (3): \n");
            while (rs.next()) {
                int escenarioId = rs.getInt("escenario_id");
                String nombreEscenario = rs.getString("nombre");
                System.out.println("Escenario ID: " + escenarioId + ", Nombre: " + nombreEscenario);
            }
            System.out.println();

            // Listado de artistas que rompen la regla
            String sqlArtistasRepetidos = "SELECT p.nombre AS nombre_persona " +
                    "FROM Presentaciones pr " +
                    "JOIN Artistas a ON pr.artista_id = a.artista_id " +
                    "JOIN Personas p ON a.persona_id = p.persona_id " +
                    "GROUP BY a.persona_id " +
                    "HAVING COUNT(DISTINCT pr.escenario_id) > 1";
            System.out.println();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlArtistasRepetidos);

            System.out.println("e. ARTISTAS QUE NO CUMPLEN LA REGLA DE TOCAR EN UN SOLO ESCENARIO: \n");
            while (rs.next()) {
                String nombrePersona = rs.getString("nombre_persona");
                System.out.println("Nombre: " + nombrePersona);
            }
            System.out.println();
            // Listado de personal de producción que rompe la regla
            String sqlPersonalRepetido = "SELECT pp.personal_id " +
                    "FROM ProduccionEscenarios pe " +
                    "JOIN PersonalProduccion pp ON pe.personal_id = pp.personal_id " +
                    "GROUP BY pe.personal_id " +
                    "HAVING COUNT(DISTINCT pe.escenario_id) > 1";

            rs = stmt.executeQuery(sqlPersonalRepetido);

            System.out.println("e. PERSONALES DE PRODUCCION QUE NO CUMPLEN LA REGLA DE TRABAJAR EN UN SOLO ESCENARIO: \n");
            while (rs.next()) {
                int personalId = rs.getInt("personal_id");
                System.out.println("ID: " + personalId );
            }
            System.out.println();

            

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
