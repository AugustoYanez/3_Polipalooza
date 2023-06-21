import java.time.LocalDate;

public class ClientesAudit {
    private int idAudit;
    private String operacion;
    private String user;
    private LocalDate last_date_modified;
    private String codCliente;
    private String razonSocial;
    private String contacto;
    private String direccion;
    private String telefono;
    private String codPost;
    private double porcDescuento;
    private Integer Provincia_idProvincia;

    public ClientesAudit(int idAudit, String operacion, String user, LocalDate last_date_modified, String codCliente, String razonSocial, String contacto, String direccion, String telefono, String codPost, double porcDescuento, Integer provincia_idProvincia) {
        this.idAudit = idAudit;
        this.operacion = operacion;
        this.user = user;
        this.last_date_modified = last_date_modified;
        this.codCliente = codCliente;
        this.razonSocial = razonSocial;
        this.contacto = contacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codPost = codPost;
        this.porcDescuento = porcDescuento;
        Provincia_idProvincia = provincia_idProvincia;
    }

    public int getIdAudit() {
        return idAudit;
    }

    public void setIdAudit(int idAudit) {
        this.idAudit = idAudit;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getLast_date_modified() {
        return last_date_modified;
    }

    public void setLast_date_modified(LocalDate last_date_modified) {
        this.last_date_modified = last_date_modified;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
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

    public String getCodPost() {
        return codPost;
    }

    public void setCodPost(String codPost) {
        this.codPost = codPost;
    }

    public double getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(double porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public Integer getProvincia_idProvincia() {
        return Provincia_idProvincia;
    }

    public void setProvincia_idProvincia(Integer provincia_idProvincia) {
        Provincia_idProvincia = provincia_idProvincia;
    }
}