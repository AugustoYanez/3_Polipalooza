import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

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
        lola.cambiarHorarioArtista(1 , new Date(2023,01,02), new Date(2023,01,02), new Date(2023,01,02));//no funciona
        System.out.println("------------------------------------------------------------");
        System.out.println("Mostrar un listado de aquellos artistas o el personal de producción que estan en más de un escenario:");
        lola.getbdd().artistasRepetidos();
        lola.getbdd().personalRepetido();
        System.out.println("------------------------------------------------------------");
        System.out.println("Artistas destacados por escenario:");
        lola.getbdd().artistaDestacadoEscenario();
        System.out.println("------------------------------------------------------------");
        System.out.println("Géneros musicales interpretados por los artistas en cada escenario:");
        lola.getbdd().ar();
        System.out.println("------------------------------------------------------------");
        System.out.println("El nombre del escenario que tiene el último show del festival:");
        lola.getbdd().ar1();//no funciona


    }
}
