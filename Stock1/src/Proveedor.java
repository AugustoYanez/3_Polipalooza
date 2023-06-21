public class Proveedor {


    private int idProveedor;

    private String razonSocial;

    private String contacto;
    private String direccion;
    private String telefono;
    private String codPostal;

    private Provincia provincia;

    public Proveedor(int idProveedor, String razonSocial, String contacto, String direccion, String telefono, String codPostal, Provincia provincia) {

        this.idProveedor = idProveedor;
        this.razonSocial = razonSocial;
        this.contacto = contacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codPostal = codPostal;
        this.provincia = provincia;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}

