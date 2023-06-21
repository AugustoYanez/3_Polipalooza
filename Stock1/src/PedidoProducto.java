public class PedidoProducto {
    private int item;
    private Integer cantidad;
    private double precioUnitario;
    private int Producto_codProducto;
    private int Pedido_idPedido;

    public PedidoProducto(int item, Integer cantidad, double precioUnitario, int producto_codProducto, int pedido_idPedido) {
        this.item = item;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        Producto_codProducto = producto_codProducto;
        Pedido_idPedido = pedido_idPedido;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getProducto_codProducto() {
        return Producto_codProducto;
    }

    public void setProducto_codProducto(int producto_codProducto) {
        Producto_codProducto = producto_codProducto;
    }

    public int getPedido_idPedido() {
        return Pedido_idPedido;
    }

    public void setPedido_idPedido(int pedido_idPedido) {
        Pedido_idPedido = pedido_idPedido;
    }
}