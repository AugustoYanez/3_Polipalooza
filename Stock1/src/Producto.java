public class Producto {
    private int codProducto;
    private String descripcion;
    private double precio;
    private int Categoria_idCategoria;
    private int stock;

    public Producto(int codProducto, String descripcion, double precio, int categoria_idCategoria, int stock) {
        this.codProducto = codProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        Categoria_idCategoria = categoria_idCategoria;
        this.stock = stock;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCategoria_idCategoria() {
        return Categoria_idCategoria;
    }

    public void setCategoria_idCategoria(int categoria_idCategoria) {
        Categoria_idCategoria = categoria_idCategoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}