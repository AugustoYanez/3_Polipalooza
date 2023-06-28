import java.time.LocalDate;

public class Personas {

   private int Persona_id;

   private String nombre;

   private String apellido;

   private LocalDate fecha_nacimiento;

   private String celular;

    public Personas(String nombre) {
        this.nombre = nombre;
    }

    public Personas(int persona_id, String nombre, String apellido, LocalDate fecha_nacimiento, String celular) {
        Persona_id = persona_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.celular = celular;
    }

    public int getPersona_id() {
        return Persona_id;
    }

    public void setPersona_id(int persona_id) {
        Persona_id = persona_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
