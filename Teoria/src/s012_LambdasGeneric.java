interface Procesador<T>{
    void procesar(T dato);
}

public class s012_LambdasGeneric {

    static void main() {
        Procesador<String> texto = dato -> System.out.println("Hola " + dato);
        texto.procesar("Carlos");
    }
}
