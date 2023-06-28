import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Escenarios {

    private int id;
    private String escenario;
    private int capacidad;
    private HashMap<Artistas, ArrayList<LocalDateTime>> presentaciones;
    private HashSet<PersonalProduccion> produccioneEscenarios;

    public Escenarios() {
    }

    public Escenarios(int id, String escenario, int capacidad, HashMap<Artistas, ArrayList<LocalDateTime>> presentaciones, HashSet<PersonalProduccion> produccioneEscenarios) {
        this.id = id;
        this.escenario = escenario;
        this.capacidad = capacidad;
        this.presentaciones = presentaciones;
        this.produccioneEscenarios = produccioneEscenarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEscenario() {
        return escenario;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public HashMap<Artistas, ArrayList<LocalDateTime>> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(HashMap<Artistas, ArrayList<LocalDateTime>> presentaciones) {
        this.presentaciones = presentaciones;
    }

    public HashSet<PersonalProduccion> getProduccioneEscenarios() {
        return produccioneEscenarios;
    }

    public void setProduccioneEscenarios(HashSet<PersonalProduccion> produccioneEscenarios) {
        this.produccioneEscenarios = produccioneEscenarios;
    }
}
