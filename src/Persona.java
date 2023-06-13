
import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private int celular_contacto;

    public Persona(String nombre, String apellido, LocalDate fecha_nacimiento, int celular_contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.celular_contacto = celular_contacto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha_nacimiento() {
        return this.fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getCelular_contacto() {
        return this.celular_contacto;
    }

    public void setCelular_contacto(int celular_contacto) {
        this.celular_contacto = celular_contacto;
    }
}
