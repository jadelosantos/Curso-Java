public class Tienda {
    public String id_producto = "id_producto";
    public String nombre = "nombre";
    public String categoria = "categoria";
    public String precio = "precio";
    public String stock = "stock";

    public Tienda() {
    }

    public Tienda(String nombre, String categoria, String precio, String stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
}
