import java.time.LocalDate;

public class Artistas extends Personas {

    private String genero_musical;

    private Boolean es_destacado;

    public Artistas(int persona_id, String nombre, String apellido, LocalDate fecha_nacimiento, String celular, String genero_musical, Boolean es_destacado) {
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
}
