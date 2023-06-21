public class Cliente {

    private int codigoCliente;

    private String razonSocial;

    private String contanto;

    private String direccion;

    private String telefono;

    private String codPost;

    private double porcDescuento;

    private Provincia provincia;

    private String categoria;

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getContanto() {
        return contanto;
    }

    public void setContanto(String contanto) {
        this.contanto = contanto;
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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Cliente(int codigoCliente, String razonSocial, String contanto, String direccion, String telefono, String codPost, double porcDescuento, Provincia provincia, String categoria) {
        this.codigoCliente = codigoCliente;
        this.razonSocial = razonSocial;
        this.contanto = contanto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codPost = codPost;
        this.porcDescuento = porcDescuento;
        this.provincia = provincia;
        this.categoria = categoria;

    }
}
