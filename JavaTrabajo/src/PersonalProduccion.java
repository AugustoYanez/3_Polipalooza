public class PersonalProduccion extends Personas {
    private int idPersonal;
    private Rol rol;

    public PersonalProduccion(int idPersonal, Rol rol) {
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
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

