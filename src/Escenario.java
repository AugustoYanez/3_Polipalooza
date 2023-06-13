
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Escenario {
    private String nombre_escenario;
    private int capacidad_maxima;
    HashMap<Integer, Artista> presentaciones;
    HashSet<Personal_produccion> personas_produccion;

    public Escenario(String nombre_escenario, int capacidad_maxima, HashMap<Integer, Artista> presentaciones, HashSet<Personal_produccion> personas_produccion) {
        this.nombre_escenario = nombre_escenario;
        this.capacidad_maxima = capacidad_maxima;
        this.presentaciones = presentaciones;
        this.personas_produccion = personas_produccion;
    }

    public String getNombre_escenario() {
        return this.nombre_escenario;
    }

    public void setNombre_escenario(String nombre_escenario) {
        this.nombre_escenario = nombre_escenario;
    }

    public int getCapacidad_maxima() {
        return this.capacidad_maxima;
    }

    public void setCapacidad_maxima(int capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public HashMap<Integer, Artista> getPresentaciones() {
        return this.presentaciones;
    }

    public void setPresentaciones(HashMap<Integer, Artista> presentaciones) {
        this.presentaciones = presentaciones;
    }

    public HashSet<Personal_produccion> getPersonas_produccion() {
        return this.personas_produccion;
    }

    public void setPersonas_produccion(HashSet<Personal_produccion> personas_produccion) {
        this.personas_produccion = personas_produccion;
    }

    public void mostrarArtistas() {
        System.out.println("TOCAN EN EL ESCENARIO: " + this.nombre_escenario);
        Iterator var1 = this.presentaciones.entrySet().iterator();

        while(var1.hasNext()) {
            Map.Entry<Integer, Artista> entry = (Map.Entry)var1.next();
            int hora = (Integer)entry.getKey();
            Artista artista = (Artista)entry.getValue();
            System.out.println("HORARIO: " + hora + " " + artista.getNombre() + " " + artista.getApellido());
        }

    }
}
