import java.time.LocalDate;
import java.util.ArrayList;

public class Artistas extends Personas {

    private String genero_musical;

    private Boolean es_destacado;
    private ArrayList<Canciones> canciones;

    public Artistas(String nombre, String genero_musical, Boolean es_destacado, ArrayList<Canciones> canciones) {
        super(nombre);
        this.genero_musical = genero_musical;
        this.es_destacado = es_destacado;
        this.canciones = canciones;
    }


    public String getGenero_musical() {
        return genero_musical;
    }

    public void setGenero_musical(String genero_musical) {
        this.genero_musical = genero_musical;
    }

    public Boolean getEs_destacado() {
        return es_destacado;
    }

    public void setEs_destacado(Boolean es_destacado) {
        this.es_destacado = es_destacado;
    }

    public ArrayList<Canciones> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Canciones> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Artistas{" +
                "genero_musical='" + genero_musical + '\'' +
                ", es_destacado=" + es_destacado +
                ", canciones=" + canciones +
                '}';
    }
}
