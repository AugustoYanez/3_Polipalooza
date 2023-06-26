import java.time.LocalDate;

public class Asistentes extends Personas {
    private Boolean es_vip;

    private String requerimiento_varchar;

    public Asistentes(int persona_id, String nombre, String apellido, LocalDate fecha_nacimiento, String celular, Boolean es_vip, String requerimiento_varchar) {
        super(persona_id, nombre, apellido, fecha_nacimiento, celular);
        this.es_vip = es_vip;
        this.requerimiento_varchar = requerimiento_varchar;
    }


    public Boolean getEs_vip() {
        return es_vip;
    }

    public void setEs_vip(Boolean es_vip) {
        this.es_vip = es_vip;
    }

    public String getRequerimiento_varchar() {
        return requerimiento_varchar;
    }

    public void setRequerimiento_varchar(String requerimiento_varchar) {
        this.requerimiento_varchar = requerimiento_varchar;
    }

}
