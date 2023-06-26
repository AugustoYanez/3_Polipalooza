import java.time.LocalDate;

public class PersonalProduccion extends Personas {
    private Roles rol;

    public PersonalProduccion(int persona_id, String nombre, String apellido, LocalDate fecha_nacimiento, String celular, Roles rol) {
        super(persona_id, nombre, apellido, fecha_nacimiento, celular);
        this.rol = rol;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}

