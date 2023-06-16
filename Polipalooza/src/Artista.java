import java.time.LocalDate;
import java.util.HashSet;

public class Artista extends Persona {
    private String genero_musical;
    HashSet<Cancion> canciones_interpreta;
    private Boolean artista_destacado;

    public Artista(String nombre, String apellido, LocalDate fecha_nacimiento, int celular_contacto, String genero_musical, HashSet<Cancion> canciones_interpreta, Boolean artista_destacado) {
        super(nombre, apellido, fecha_nacimiento, celular_contacto);
        this.genero_musical = genero_musical;
        this.canciones_interpreta = canciones_interpreta;
        this.artista_destacado = artista_destacado;
    }

    public String getGenero_musical() {
        return this.genero_musical;
    }

    public HashSet<Cancion> getCanciones_interpreta() {
        return this.canciones_interpreta;
    }

    public void setGenero_musical(String genero_musical) {
        this.genero_musical = genero_musical;
    }

    public void setCanciones_interpreta(HashSet<Cancion> canciones_interpreta) {
        this.canciones_interpreta = canciones_interpreta;
    }

    public Boolean getArtista_destacado() {
        return this.artista_destacado;
    }

    public void setArtista_destacado(Boolean artista_destacado) {
        this.artista_destacado = artista_destacado;
    }
}
