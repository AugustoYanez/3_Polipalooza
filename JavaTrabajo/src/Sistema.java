import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Sistema {
    private HashSet<Escenarios>escenarios;
    private HashSet<PersonalProduccion>personal;
    private AccesoBaseDeDatos bdd;

    public Sistema() {
        escenarios = new HashSet<>();
        personal = this.crearPersonal(-1);
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
            persProd.add(new PersonalProduccion(p.getKey(),Rol.valueOf(p.getValue().get("nombreRol").toString().toUpperCase())));
        }
        return persProd;
    }
    public HashMap<Artistas, ArrayList<LocalDateTime>> crearPresentacion(int id){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        HashMap<Artistas, ArrayList<LocalDateTime>> pres = new HashMap<>();
        HashMap<Integer,HashMap<String,Object>> ps = bdd.cargarPresentaciones(id);
        for (Map.Entry<Integer, HashMap<String, Object>> p:ps.entrySet()) {
            ArrayList<LocalDateTime> horarios = new ArrayList<>();
            HashMap<String, Object> h = p.getValue();
            horarios.add(LocalDateTime.parse((String) h.get("horario_inicio"),formatter));
            horarios.add(LocalDateTime.parse((String) h.get("horario_fin"), formatter));
            pres.put(new Artistas(h.get("nombre").toString(), h.get("genero_musical").toString(), (Boolean) h.get("es_destacado"), null), horarios);
        }
        return pres;
    }
    public HashSet<Escenarios> crearEscenario(){
        HashSet<Escenarios> escenarios = new HashSet<>();
        HashMap<Integer,HashMap<String,Object>> ps = bdd.cargarEscenario();
        for (Map.Entry<Integer, HashMap<String, Object>> p:ps.entrySet()) {
            HashMap<String, Object> h = p.getValue();
            escenarios.add(new Escenarios(p.getKey(), h.get("nombre").toString(), (int) h.get("capacidad_maxima"), crearPresentacion(p.getKey()), crearPersonal(p.getKey())));
        }
        return escenarios;
    }

    public String artistaMasJoven(){
        String masJoven = "";
        for (Escenarios i : escenarios){
            Artistas currentMasJoven = new Artistas(LocalDate.now());
            for (   Map.Entry<Artistas,ArrayList<LocalDateTime>> hash:i.getPresentaciones().entrySet()) {
                Artistas a = hash.getKey();
                if (currentMasJoven.getFecha_nacimiento().isBefore(a.getFecha_nacimiento())){
                    currentMasJoven = a;
                }
            }
            masJoven += "escenario " + i.getId() + ": " + currentMasJoven.getNombre() + "\n";
        }

        return masJoven;
    }

    public HashSet<Escenarios> escenarioPersonalInsuficiente(){
        HashSet<Rol>roles = new HashSet<>();
        HashSet<Escenarios> escenarioConPersonalInsuficiente = new HashSet<>();
        for (Escenarios e : escenarios){
            for (PersonalProduccion p : e.getProduccioneEscenarios()){
                roles.add(p.getRol());
            }
            if (roles.size()<3){
                escenarioConPersonalInsuficiente.add(e);
            }
        }

        return escenarioConPersonalInsuficiente;
    }


    public static void main(String[] args) {
        Sistema lolla2023 = new Sistema();

        try {
            lolla2023.getbdd().conectar("alumno","alumnoipm");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //cargar todas las colecciones
        lolla2023.setEscenarios(lolla2023.crearEscenario());
        lolla2023.setPersonal(lolla2023.crearPersonal(-1));


        //resuelvo las consignas.
        //3-a
        System.out.println("PUNTO A:");
        lolla2023.getbdd().artistaPorEscenario();
        //3-b
        System.out.println("PUNTO B:");
        lolla2023.artistaMasJoven();
        //3-c
        System.out.println("PUNTO C:");
        lolla2023.escenarioPersonalInsuficiente();
        //3-d






// Para hacer el punto D:
// Obtener de lolla2023.getbdd().escenarios() todos los escenarios lolla2023.setEscnarios()
// una vez qu etengo eso cargado, recorro mi hashset escenarios (lolla2023.getEscenarios())
// por cada unoi voy a agarrar el id del escenario y llamo a mi funcion o procedure de bdd
// que recibe un id escenario y me devuelve todos los artistas que estan ahi con su respectivo horario
// y actualiop entonces el hashmap de ese escenairo con esos datos

    }
}