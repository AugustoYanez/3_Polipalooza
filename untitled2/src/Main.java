import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Sistema lola = new Sistema();
        try {
            lola.getbdd().conectar("alumno","alumnoipm");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        lola.escenarioSistema();
        lola.personalSistema();
        lola.escenarioPersonal();

        System.out.println("Artistas por escenario:");
        lola.getbdd().artistaPorEscenario();
        System.out.println("------------------------------------------------------------");
        System.out.println("Artista mas joven por escenario:");
        lola.getbdd().artistaMasJoven();
        System.out.println("------------------------------------------------------------");
        System.out.println("Escenarios en los cuales no se alcance el personal mínimo requerido:");
        lola.getbdd().escenarioPersonalInsuficiente();
        System.out.println("------------------------------------------------------------");
        System.out.println("Cambiar al artista que tocaba a las 15hs en un escenario para ponerlo a las 17hs en otro:");
        lola.getbdd().escenarioPersonalInsuficiente();
        System.out.println("------------------------------------------------------------");

    }
}
