import Cancion.Cancion;
import Escenario.Escenario;
import Personas.Artista;
import Personas.Asistente;

import java.util.HashSet;

public class Polipalooza {

    private HashSet<Artista> artistas;
    private HashSet<Asistente> asistentes;
    private Escenario escenario;

    public Polipalooza(HashSet<Artista> artistas, HashSet<Asistente> asistentes, Escenario escenario) {
        this.artistas = artistas;
        this.asistentes = asistentes;
        this.escenario = escenario;
    }

    public HashSet<Artista> getArtista() {
        return artistas;
    }

    public void setArtista(HashSet<Artista> artistas) {
        this.artistas = artistas;
    }

    public HashSet<Asistente> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(HashSet<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }





}
