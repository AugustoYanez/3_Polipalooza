
import java.time.LocalDate;

public class Asistente extends Persona {
    private Boolean asistente_vip;
    private String requerimiento_especial;

    public Asistente(String nombre, String apellido, LocalDate fecha_nacimiento, int celular_contacto, Boolean asistente_vip, String requerimiento_especial) {
        super(nombre, apellido, fecha_nacimiento, celular_contacto);
        this.asistente_vip = asistente_vip;
        this.requerimiento_especial = requerimiento_especial;
    }

    public Boolean getAsistente_vip() {
        return this.asistente_vip;
    }

    public void setAsistente_vip(Boolean asistente_vip) {
        this.asistente_vip = asistente_vip;
    }

    public String getRequerimiento_especial() {
        return this.requerimiento_especial;
    }

    public void setRequerimiento_especial(String requerimiento_especial) {
        this.requerimiento_especial = requerimiento_especial;
    }
}
