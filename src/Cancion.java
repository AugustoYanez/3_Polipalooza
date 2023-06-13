

public class Cancion {
    private Artista artista_autor;
    private String nombre;

    public Cancion(Artista artista_autor, String nombre) {
        this.artista_autor = artista_autor;
        this.nombre = nombre;
    }

    public Artista getArtista_autor() {
        return this.artista_autor;
    }

    public void setArtista_autor(Artista artista_autor) {
        this.artista_autor = artista_autor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

