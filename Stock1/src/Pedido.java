import java.time.LocalDate;

public class Pedido {
    private int idPedido;
    private LocalDate fecha;
    private int Estado_idEstado;
    private String Cliente_codCliente;

    public Pedido(int idPedido, LocalDate fecha, int estado_idEstado, String cliente_codCliente) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        Estado_idEstado = estado_idEstado;
        Cliente_codCliente = cliente_codCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getEstado_idEstado() {
        return Estado_idEstado;
    }

    public void setEstado_idEstado(int estado_idEstado) {
        Estado_idEstado = estado_idEstado;
    }

    public String getCliente_codCliente() {
        return Cliente_codCliente;
    }

    public void setCliente_codCliente(String cliente_codCliente) {
        Cliente_codCliente = cliente_codCliente;
    }
}