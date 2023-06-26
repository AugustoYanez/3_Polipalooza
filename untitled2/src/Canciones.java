public class Canciones {

    private int cancion_id;

    private int artista_id;

    private String nombre_cancion;

    public Canciones(int cancion_id, int artista_id, String nombre_cancion) {
        this.cancion_id = cancion_id;
        this.artista_id = artista_id;
        this.nombre_cancion = nombre_cancion;
    }

    public int getCancion_id() {
        return cancion_id;
    }

    public void setCancion_id(int cancion_id) {
        this.cancion_id = cancion_id;
    }

    public int getArtista_id() {
        return artista_id;
    }

    public void setArtista_id(int artista_id) {
        this.artista_id = artista_id;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }
}
