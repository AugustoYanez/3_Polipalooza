import java.sql.Date;
import java.util.ArrayList;

public class Artistas extends Personas {

    private String genero_musical;

    private Boolean es_destacado;
    private ArrayList<Canciones> canciones;

    public Artistas(String nombre, java.sql.Date fecha_nacimiento, String genero_musical, Boolean es_destacado, ArrayList<Canciones> canciones) {
        super(nombre, fecha_nacimiento);
        this.genero_musical = genero_musical;
        this.es_destacado = es_destacado;
        this.canciones = canciones;
    }

    public Artistas(java.sql.Date fecha_nacimiento) {
        super(fecha_nacimiento);
    }

    public Artistas(int persona_id, String nombre, String apellido, Date fecha_nacimiento, String celular, String genero_musical, Boolean es_destacado) {
        super(persona_id, nombre, apellido, fecha_nacimiento, celular);
        this.genero_musical = genero_musical;
        this.es_destacado = es_destacado;
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
                '}';
    }
}
