public class IngresoStockProducto {
    private int item;
    private  int cantidad;
    private int IngresoStock_idIngreso;
    private int Producto_codProducto;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIngresoStock_idIngreso() {
        return IngresoStock_idIngreso;
    }

    public void setIngresoStock_idIngreso(int ingresoStock_idIngreso) {
        IngresoStock_idIngreso = ingresoStock_idIngreso;
    }

    public int getProducto_codProducto() {
        return Producto_codProducto;
    }

    public void setProducto_codProducto(int producto_codProducto) {
        Producto_codProducto = producto_codProducto;
    }

    public IngresoStockProducto(int item, int cantidad, int ingresoStock_idIngreso, int producto_codProducto) {
        this.item = item;
        this.cantidad = cantidad;
        IngresoStock_idIngreso = ingresoStock_idIngreso;
        Producto_codProducto = producto_codProducto;
    }
}