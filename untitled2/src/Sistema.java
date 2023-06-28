import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Sistema {
    private HashSet<Escenarios> escenarios;
    private HashSet<PersonalProduccion> personal;
    private AccesoBaseDeDatos bdd;

    public Sistema() {
        escenarios = new HashSet<>();
        personal = new HashSet<>();
        List<String> tablas = Arrays.asList("Artistas", "Asistentes", "Canciones", "Escenarios", "PersonalProduccion", "Personas", "Presentaciones", "ProduccionEscenarios", "roles");
        bdd = new AccesoBaseDeDatos("Polipalooza", tablas);
    }

    public HashSet<Escenarios> getEscenarios() {
        return escenarios;
    }

    public void setEscenarios(HashSet<Escenarios> escenarios) {
        this.escenarios = escenarios;
    }

    public HashSet<PersonalProduccion> getPersonal() {
        return personal;
    }

    public void setPersonal(HashSet<PersonalProduccion> personal) {
        this.personal = personal;
    }

    public AccesoBaseDeDatos getbdd() {
        return bdd;
    }

    public void setbdd(AccesoBaseDeDatos bdd) {
        this.bdd = bdd;
    }

    public Sistema(HashSet<Escenarios> escenarios, HashSet<PersonalProduccion> personal, AccesoBaseDeDatos bdd) {
        this.escenarios = escenarios;
        this.personal = personal;
        this.bdd = bdd;
    }

    public void remplazarEscenario(){

        setEscenarios(bdd.cargarEscenarios());
        for (Escenarios e:escenarios){
            int id = e.getId();

        }
    }
    // Para hacer el punto D:
    //Obtener de  lolla2023.getbdd().escenarios() todos los escenarios lolla2023.setEscnarios()
    // una vez qu etengo eso cargado, recorro mi hashset escenarios (lolla2023.getEscenarios())
    // por cada unoi voy a agarrar el id del escenario y llamo a mi funcion o procedure de bdd
    // que recibe un id escenario y me devuelve todos los artistas que estan ahi con su respectivo horario
    // y actualiop entonces el hashmap de ese escenairo con esos datos

    public static void main(String[] args) {
        Sistema lolla2023 = new Sistema();


        try {
            lolla2023.getbdd().conectar("alumno","alumnoipm");

        } catch (SQLException ex) {
            System.out.println(ex);
        }


        HashSet<Artistas> artistas = lolla2023.getbdd().obtenerDatosArtista();
        for(Artistas a:artistas){
            System.out.println(a);
        }




        lolla2023.getbdd().artistaPorEscenario();
        lolla2023.getbdd().cargarEscenarios();

        /*lolla2023.getbdd().artistaPorEscenario();
        lolla2023.getbdd().artistaMasJoven();
        lolla2023.getbdd().escenarioPersonalInsuficiente();
        lolla2023.getbdd().artistasRepetidos();
        lolla2023.getbdd().personalRepetido();*/






    }
}
