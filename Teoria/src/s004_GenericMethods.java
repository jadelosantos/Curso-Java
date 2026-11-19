interface Almacen<T>{
    void guardar(T dato);
    T obtener();
}

class AlmacenTexto implements Almacen<String>{

    private String dato;

    @Override
    public void guardar(String dato) {
        this.dato = dato;
    }

    @Override
    public String obtener() {
        return dato;
    }
}


public class s004_GenericMethods {
    public static <T> void mostrar(T dato){
        System.out.println(dato);
    }

    public static <T> T mostrar2(T dato){
        return dato;
    }
    static void main() {
        mostrar("Java");
        mostrar(25);
        mostrar(19.95);
        System.out.println("Dato: " + mostrar2("miguel"));

        AlmacenTexto obj1 = new AlmacenTexto();
        obj1.guardar("Hola, Java");
        System.out.println(obj1.obtener());

    }
}
