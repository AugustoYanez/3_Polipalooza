import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Escenarios {

    private String escenario;
    private int capacidad;
    private HashMap< Artistas, ArrayList<Date>> presentaciones;
    private HashSet<PersonalProduccion> produccioneEscenarios;

    public Escenarios(String escenario, int capacidad, HashMap<Artistas, ArrayList<Date>> presentaciones, HashSet<PersonalProduccion> produccioneEscenarios) {
        this.escenario = escenario;
        this.capacidad = capacidad;
        this.presentaciones = presentaciones;
        this.produccioneEscenarios = produccioneEscenarios;
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

    public HashMap<Artistas, ArrayList<Date>> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(HashMap<Artistas, ArrayList<Date>> presentaciones) {
        this.presentaciones = presentaciones;
    }

    public HashSet<PersonalProduccion> getProduccioneEscenarios() {
        return produccioneEscenarios;
    }

    public void setProduccioneEscenarios(HashSet<PersonalProduccion> produccioneEscenarios) {
        this.produccioneEscenarios = produccioneEscenarios;
    }
}
