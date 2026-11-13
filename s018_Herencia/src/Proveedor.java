public class Proveedor {
    // Atributos comunes
    String nombre;
    String producto;
    double precio;

    // Constructor
    public Proveedor(String nombre, String producto, double precio) {
        this.nombre = nombre;
        this.producto = producto;
        this.precio = precio;
    }

    // Método común
    public void mostrarDatos() {
        System.out.println("Proveedor: " + nombre);
        System.out.println("Producto: " + producto);
        System.out.println("Precio: " + precio + " euros");
    }
}
