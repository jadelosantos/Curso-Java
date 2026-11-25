public class Pedidos {
    public String id_pedido = "id_pedido";
    public String fecha = "fecha";
    public String cantidad = "cantidad";
    public String id_plato = "id_plato";

    public Pedidos() {
    }

    public Pedidos(String id_pedido, String fecha, String cantidad, String id_plato) {
        this.id_pedido = id_pedido;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.id_plato = id_plato;
    }
}
