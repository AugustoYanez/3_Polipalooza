import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
    public HashSet<PersonalProduccion> crearPersonal(int id){
        HashSet<PersonalProduccion> persProd = new HashSet<>();
        HashMap<Integer, HashMap<String, Object>> ps = bdd.cargarPersonal1(id);
        for (Map.Entry<Integer, HashMap<String, Object>> p:ps.entrySet()) {
            persProd.add(new PersonalProduccion(p.getKey(),p.getValue().get("nombreRol").toString()));
        }
        return persProd;
    }
    public HashMap<Artistas, ArrayList<LocalDateTime>> crearPresentacion(int id){
        HashMap<Artistas, ArrayList<LocalDateTime>> pres = new HashMap<>();
        HashMap<Integer,HashMap<String,Object>> ps = bdd.cargarPresentaciones(id);
        for (Map.Entry<Integer, HashMap<String, Object>> p:ps.entrySet()) {
            ArrayList<LocalDateTime> horarios = new ArrayList<>();
            HashMap<String, Object> h = p.getValue();
            horarios.add((LocalDateTime) h.get("horario_inicio"));
            horarios.add((LocalDateTime) h.get("horario_fin"));
            pres.put(new Artistas(h.get("nombre").toString(), h.get("genero_musical").toString(), (Boolean) h.get("es_destacado"), null), horarios);
        }
        return pres;
    }
    public HashSet<Escenarios> crearEscenario(){
        HashSet<Escenarios> escenarios = new HashSet<>();
        HashMap<Integer,HashMap<String,Object>> ps = bdd.cargarEscenario();
        for (Map.Entry<Integer, HashMap<String, Object>> p:ps.entrySet()) {
            HashMap<Artistas, ArrayList<LocalDateTime>> presentaciones = crearPresentacion(p.getKey());
            HashMap<String, Object> h = p.getValue();
            System.out.println(p.getKey() + "      " + h.get("nombre") + "       " + h.get("capacidad_maxima"));
            for (Map.Entry<Artistas,ArrayList<LocalDateTime>> a: presentaciones.entrySet() ) {
                Artistas a1 = a.getKey();
                ArrayList<LocalDateTime> horarios = a.getValue();
                System.out.println(a1.toString() + "      " + horarios.get(0).toString() + "         " + horarios.get(1).toString());
            }
            //escenarios.add(new Escenarios(p.getKey(), h.get("nombre").toString(), (int) h.get("capacidad_maxima"), crearPresentacion((int) h.get("escenario_id")), crearPersonal((int) h.get("escenario_id"))));
        }
        return escenarios;
    }
   /** public void escenarioSistema(){
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
    public void cambiarHorarioArtista(int escenario, Date editar,Date editar1, Date inicio){
        HashMap< Artistas, ArrayList<Date> > remplazo1 = new HashMap<>();
        for (Escenarios e:escenarios) {
            if (e.getId() == escenario){
                for (Map.Entry<Artistas, ArrayList<Date>> presentacion: e.getPresentaciones().entrySet()) {
                    ArrayList<Date> remplazo = new ArrayList<>();
                    if (presentacion.getValue().get(0).equals(inicio)){
                        remplazo.add(editar);
                        remplazo.add(editar1);
                        remplazo1.put(presentacion.getKey(), remplazo);
                    }else {
                        remplazo1.put(presentacion.getKey(),presentacion.getValue());
                    }
                    e.setPresentaciones(remplazo1);
                }
            }
        }
    }**/

    public static void main(String[] args) {
        Sistema lolla2023 = new Sistema();


        try {
            lolla2023.getbdd().conectar("alumno","alumnoipm");

        } catch (SQLException ex) {
            System.out.println(ex);
        }



        // Para hacer el punto D:
        // Obtener de  lolla2023.getbdd().escenarios() todos los escenarios lolla2023.setEscnarios()
        // una vez qu etengo eso cargado, recorro mi hashset escenarios (lolla2023.getEscenarios())
        // por cada unoi voy a agarrar el id del escenario y llamo a mi funcion o procedure de bdd
        // que recibe un id escenario y me devuelve todos los artistas que estan ahi con su respectivo horario
        // y actualiop entonces el hashmap de ese escenairo con esos datos

    }
}
