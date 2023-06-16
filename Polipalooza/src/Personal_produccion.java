
import java.time.LocalDate;

public class Personal_produccion extends Persona {
    private Rol_produccion rol_del_personal_produccion;

    public Personal_produccion(String nombre, String apellido, LocalDate fecha_nacimiento, int celular_contacto, Rol_produccion rol_del_personal_produccion) {
        super(nombre, apellido, fecha_nacimiento, celular_contacto);
        this.rol_del_personal_produccion = rol_del_personal_produccion;
    }

    public Rol_produccion getRol_del_personal_produccion() {
        return this.rol_del_personal_produccion;
    }

    public void setRol_del_personal_produccion(Rol_produccion rol_del_personal_produccion) {
        this.rol_del_personal_produccion = rol_del_personal_produccion;
    }
}
