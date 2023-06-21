public class ProductoProveedor {
    private int Proveedor_idProveedor;
    private int Producto_codProducto;
    private double precio;
    private Integer demoraEntrega;

    public int getProveedor_idProveedor() {
        return Proveedor_idProveedor;
    }

    public void setProveedor_idProveedor(int proveedor_idProveedor) {
        Proveedor_idProveedor = proveedor_idProveedor;
    }

    public int getProducto_codProducto() {
        return Producto_codProducto;
    }

    public void setProducto_codProducto(int producto_codProducto) {
        Producto_codProducto = producto_codProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getDemoraEntrega() {
        return demoraEntrega;
    }

    public void setDemoraEntrega(Integer demoraEntrega) {
        this.demoraEntrega = demoraEntrega;
    }

    public ProductoProveedor(int proveedor_idProveedor, int producto_codProducto, double precio, Integer demoraEntrega) {
        Proveedor_idProveedor = proveedor_idProveedor;
        Producto_codProducto = producto_codProducto;
        this.precio = precio;
        this.demoraEntrega = demoraEntrega;


    }
}