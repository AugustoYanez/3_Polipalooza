import java.time.LocalDate;

public class PersonalProduccion extends Personas {
    private int idPersonal;
    private String rol;

    public PersonalProduccion(int idPersonal, String rol) {
        super();
        this.idPersonal = idPersonal;
        this.rol = rol;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "PersonalProduccion{" +
                "idPersonal=" + idPersonal +
                ", rol='" + rol + '\'' +
                '}';
    }
}

