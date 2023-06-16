
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class main {

    public static Connection connectarBD(){
Connection conexion;
String host = "jdbc:mysql://localhost:3306/";
String user = "alumno";
String pass = "alumnoipm";
String bd = "Polipalooza";

        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host+bd,user,pass);
            System.out.println("CONECTADO.");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            throw new RuntimeException(e);
        }
return conexion;
    }



    public static void main(String[] args) {

          List<String> tablas = Arrays.asList("Artistas");

          AccesoBaseDeDatos bdd = new AccesoBaseDeDatos("Polipalooza",tablas);
        try {
            bdd.conectar("alumno","alumnoipm");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         ArrayList<String> artistas = new ArrayList<>();

        artistas = bdd.obtenerSelectConMasDeUnValor("Artistas","genero_musical","artista_id","1");

        for (String f : artistas){
            System.out.println( "genero: " + f);
        }







    }}

