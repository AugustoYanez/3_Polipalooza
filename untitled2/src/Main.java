import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
            Sistema lola = new Sistema();

        System.out.println(lola.artistaMasJoven());
        lola.doblePresentacion();
        for (Escenarios e: lola.getEscenarios()) {
            for ( Map.Entry<Artistas,ArrayList<LocalDateTime>> p: e.getPresentaciones().entrySet()) {
                System.out.println(p.getKey().getNombre()+ "  -  " + p.getValue().get(0) + " a " + p.getValue().get(1));
            }
        }
    }
}
