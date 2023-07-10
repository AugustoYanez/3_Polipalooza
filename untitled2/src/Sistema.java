import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.util.*;

public class Sistema {
    private HashSet<Escenarios>escenarios;
    private HashSet<PersonalProduccion>personal;
    private AccesoBaseDeDatos bdd;

    public Sistema() {
        List<String> tablas = Arrays.asList("Artistas", "Asistentes", "Canciones", "Escenarios","PersonalProduccion","Personas","Presentaciones","ProduccionEscenarios","roles");
        bdd = new AccesoBaseDeDatos("Polipalooza", tablas, "alumno", "alumnoipm");
        escenarios = crearEscenario();
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        HashMap<Artistas, ArrayList<LocalDateTime>> pres = new HashMap<>();
        HashMap<Integer,HashMap<String,Object>> ps = bdd.cargarPresentaciones(id);
        for (Map.Entry<Integer, HashMap<String, Object>> p:ps.entrySet()) {
            ArrayList<LocalDateTime> horarios = new ArrayList<>();
            HashMap<String, Object> h = p.getValue();
            horarios.add(LocalDateTime.parse((String) h.get("horario_inicio"),formatter));
            horarios.add(LocalDateTime.parse((String) h.get("horario_fin"), formatter));
            pres.put(new Artistas(h.get("nombre").toString(), (Date) h.get("fecha_nacimiento"), h.get("genero_musical").toString(), (Boolean) h.get("es_destacado"), null), horarios);
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
        this.setPersonal(crearPersonal(-1));
        return escenarios;
    }

    public String artistaMasJoven(){
        String masJoven = "";
        for (Escenarios i : this.getEscenarios()){
            Artistas currentMasJoven = null;
            for (Map.Entry<Artistas,ArrayList<LocalDateTime>> hash:i.getPresentaciones().entrySet()) {
                Artistas a = hash.getKey();
                if (currentMasJoven == null || currentMasJoven.getFecha_nacimiento().before(a.getFecha_nacimiento())){
                    currentMasJoven = a;
                }
            }
            masJoven += "escenario " + i.getId() + ": " + currentMasJoven.getNombre() + "\n";
        }

        return masJoven;
    }
}
