public class ProveedorInternacional extends Proveedor {
    
    public ProveedorInternacional(String nombre, String producto, double precio) {
        super(nombre, producto, precio);
    }

    public void mostrarPais() {
        System.out.println("País: Alemania");
    }
}
