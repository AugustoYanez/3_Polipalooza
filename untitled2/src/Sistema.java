import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class Sistema {
    private HashSet<Escenarios>escenarios;
    private HashSet<PersonalProduccion>personal;
    private AccesoBaseDeDatos bdd;

    public Sistema() {
        escenarios = new HashSet<>();
        personal = new HashSet<>();
        List<String> tablas = Arrays.asList("Artistas", "Asistentes", "Canciones", "Escenarios","PersonalProduccion","Personas","Presentaciones","ProduccionEscenarios","roles");
        bdd = new AccesoBaseDeDatos("Polipalooza", tablas);
    }
    public Sistema(HashSet<Escenarios> escenarios, HashSet<PersonalProduccion> personal, AccesoBaseDeDatos bdd) {
        this.escenarios = escenarios;
        this.personal = personal;
        this.bdd = bdd;
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
    public void escenarioSistema(){
        this.setEscenarios(bdd.cargarEscenarios());
    }
    public void personalSistema(){
        setPersonal(this.bdd.cargarPersonal());
    }
    public void escenarioPersonal(){
        for(Escenarios e: escenarios){
            e.setProduccioneEscenarios(bdd.cargarPersonalEscenario(e.getId()));
        }
    }
    public void cambiarHorarioArtista(int escenario, Date editar, Date inicio){
        for (Escenarios e:escenarios) {
            if (e.getId() == escenario){
                for (ArrayList<Date> listaDeFechas : e.getPresentaciones().values()) {
                    Date primerFecha = listaDeFechas.get(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        Sistema lolla2023 = new Sistema();


        try {
            lolla2023.getbdd().conectar("alumno","alumnoipm");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        lolla2023.escenarioSistema();
        lolla2023.personalSistema();
        lolla2023.escenarioPersonal();

        lolla2023.getbdd().artistaPorEscenario();


        // Para hacer el punto D:
        // Obtener de  lolla2023.getbdd().escenarios() todos los escenarios lolla2023.setEscnarios()
        // una vez qu etengo eso cargado, recorro mi hashset escenarios (lolla2023.getEscenarios())
        // por cada unoi voy a agarrar el id del escenario y llamo a mi funcion o procedure de bdd
        // que recibe un id escenario y me devuelve todos los artistas que estan ahi con su respectivo horario
        // y actualiop entonces el hashmap de ese escenairo con esos datos

    }
}
