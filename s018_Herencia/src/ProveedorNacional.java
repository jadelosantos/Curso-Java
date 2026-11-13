public class ProveedorNacional extends Proveedor {
    
    public ProveedorNacional(String nombre, String producto, double precio) {
        super(nombre, producto, precio);
    }

    public void mostrarPais() {
        System.out.println("País: España");
    }
}
