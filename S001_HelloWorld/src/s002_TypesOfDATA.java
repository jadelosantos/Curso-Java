public class s002_TypesOfDATA {
    public static void main(String[] args) {
        // byte
        // Almacena números enteros pequeños
        // -128 hasta 127
        byte menor = 112;
        System.out.println("Número de alumnos " + menor);

        // short
        // Almacena númerps enteros desde -32.768 hasta 32.767
        short productos = 15000;
        System.out.println("Productos disponibles " + productos);

        // int
        // Uno de los tipos más utilizados para almacenar números enteros
        // desde -2.147.483.648 hasta 2.147.483.647
        int edad = 30;
        System.out.println("Edad del cliente " + edad);

        // double
        // Almacena números decimales con mayor precisión que float
        double distancia = 125.6789;
        System.out.println("Distancia recorrida: " + distancia + " km");

        // string
        // Almacena una cadena de caracteres, es decir, texto.
        String nombre = "Carlos";

        // char
        // Almacena un único carácter, como una letra, un dígito o un símbolo.
        char nota = 'A';
        System.out.println("Nota del alumno " + nota);

        // boolean
        boolean aprobado = true;
        System.out.println("¿Ha aprobado el alumno? " + aprobado);
    }
}
