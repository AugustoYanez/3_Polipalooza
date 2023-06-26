import java.time.LocalDate;

public class Presentaciones {

    private int presentaciones_id;

    private int escenario_id;

    private int artista_id;

    private LocalDate horario_inicio;
    private LocalDate horario_fin;

    public Presentaciones(int presentaciones_id, int escenario_id, int artista_id, LocalDate horario_inicio, LocalDate horario_fin) {
        this.presentaciones_id = presentaciones_id;
        this.escenario_id = escenario_id;
        this.artista_id = artista_id;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
    }

    public int getPresentaciones_id() {
        return presentaciones_id;
    }

    public void setPresentaciones_id(int presentaciones_id) {
        this.presentaciones_id = presentaciones_id;
    }

    public int getEscenario_id() {
        return escenario_id;
    }

    public void setEscenario_id(int escenario_id) {
        this.escenario_id = escenario_id;
    }

    public int getArtista_id() {
        return artista_id;
    }

    public void setArtista_id(int artista_id) {
        this.artista_id = artista_id;
    }

    public LocalDate getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(LocalDate horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public LocalDate getHorario_fin() {
        return horario_fin;
    }

    public void setHorario_fin(LocalDate horario_fin) {
        this.horario_fin = horario_fin;
    }

}
