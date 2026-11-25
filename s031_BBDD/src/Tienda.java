public class Tienda {
    public String id_producto = "id_producto";
    public String nombre = "nombre";
    public String categoria = "categoria";
    public String precio = "precio";
    public String stock = "stock";

    public Tienda() {
    }

    public Tienda(String id_producto, String nombre, String categoria, String precio, String stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
}
