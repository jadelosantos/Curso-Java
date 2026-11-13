public class mainProveedor {
    static void main(String[] args) {
        // OBJETO 1: Proveedor nacional
        ProveedorNacional proveedor1 = new ProveedorNacional("HP", "Impresoras", 300);

        // OBJETO 2: Proveedor internacional
        ProveedorInternacional proveedor2 = new ProveedorInternacional("Samsung", "Monitores", 200);

        // OBJETO 3: Otro proveedor nacional
        ProveedorNacional proveedor3 = new ProveedorNacional("Dell", "Portatiles", 900);

        // EJECUTAR METODOS
        proveedor1.mostrarDatos();
        proveedor1.mostrarPais();
        System.out.println("-----");

        proveedor2.mostrarDatos();
        proveedor2.mostrarPais();
        System.out.println("------");

        proveedor3.mostrarDatos();
        proveedor3.mostrarPais();
    }
}
