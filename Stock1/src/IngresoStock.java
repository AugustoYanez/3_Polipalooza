import java.time.LocalDate;

public class IngresoStock {
    private int idIngreso;
    private LocalDate fecha;
    private String remitoNro;
    private int Proveedor_idProveedor;

    public IngresoStock(int idIngreso, LocalDate fecha, String remitoNro, int proveedor_idProveedor) {
        this.idIngreso = idIngreso;
        this.fecha = fecha;
        this.remitoNro = remitoNro;
        Proveedor_idProveedor = proveedor_idProveedor;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getRemitoNro() {
        return remitoNro;
    }

    public void setRemitoNro(String remitoNro) {
        this.remitoNro = remitoNro;
    }

    public int getProveedor_idProveedor() {
        return Proveedor_idProveedor;
    }

    public void setProveedor_idProveedor(int proveedor_idProveedor) {
        Proveedor_idProveedor = proveedor_idProveedor;
    }
}