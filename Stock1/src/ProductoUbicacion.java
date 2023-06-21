public class ProductoUbicacion {
    private int idProducto_Ubicacion;
    private int cantidad;
    private String estanteria;
    private int Producto_codProducto;

    public int getIdProducto_Ubicacion() {
        return idProducto_Ubicacion;
    }

    public void setIdProducto_Ubicacion(int idProducto_Ubicacion) {
        this.idProducto_Ubicacion = idProducto_Ubicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(String estanteria) {
        this.estanteria = estanteria;
    }

    public int getProducto_codProducto() {
        return Producto_codProducto;
    }

    public void setProducto_codProducto(int producto_codProducto) {
        Producto_codProducto = producto_codProducto;
    }

    public ProductoUbicacion(int idProducto_Ubicacion, int cantidad, String estanteria, int producto_codProducto) {
        this.idProducto_Ubicacion = idProducto_Ubicacion;
        this.cantidad = cantidad;
        this.estanteria = estanteria;
        Producto_codProducto = producto_codProducto;


    }
}