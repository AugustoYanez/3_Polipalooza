

import java.util.HashSet;

public class Polipalooza {
    private HashSet<Artista> artistas;
    private HashSet<Asistente> asistentes;
    private HashSet<Escenario> escenario;


    public Polipalooza(HashSet<Artista> artistas, HashSet<Asistente> asistentes,HashSet<Escenario> escenario) {
        this.artistas = artistas;
        this.asistentes = asistentes;
        this.escenario = escenario;
    }

    public HashSet<Artista> getArtista() {
        return this.artistas;
    }

    public void setArtista(HashSet<Artista> artistas) {
        this.artistas = artistas;
    }

    public HashSet<Asistente> getAsistentes() {
        return this.asistentes;
    }

    public void setAsistentes(HashSet<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public void setEscenario(HashSet<Escenario> escenario) {
        this.escenario = escenario;
    }

}
