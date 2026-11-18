import java.util.Scanner;

public class s027_funcionesStrings {
    private static String frase1;
    private static String frase2;
    private static String frase3;
    private static Scanner sc = new Scanner(System.in);
    static void main() {
        // 1. Información de la cadena
        //    - Mostrar el texto introducido.
        //    - Mostrar el número de caracteres utilizando length().
        //    - Comprobar si la cadena está vacía utilizando isEmpty().
        //    - Comprobar si la cadena está vacía o contiene únicamente espacios en blanco utilizando isBlank().
        System.out.println("Introduce la frase: ");
        frase1 = sc.nextLine();
        System.out.println(frase1);
        System.out.println("Numero de caracteres: " + frase1.length());
        System.out.println(frase1.isEmpty() ? "La frase no contiene caracteres" : "La frase contiene caracteres");
        System.out.println(frase1.isBlank() ? "La frase contiene espacios en blanco" : "La frase no contiene espacios en blanco");
        // 2. Búsqueda de texto
        //    - Solicitar al usuario una palabra para buscar dentro del texto.
        //    - Comprobar si esa palabra existe utilizando contains().
        System.out.println("Introduzca la palabra para empezar a buscar:");
        frase2 = sc.nextLine();
        System.out.println(frase2.contains(frase1) ? "La palabra se encuentra dentro de la frase" : "La palabra no se encuentra dentro de la frase");
        // 3. Modificación del texto
        //    - Eliminar los espacios exteriores con trim().
        //    - Sustituir todas las apariciones de una letra por otra utilizando replace().
        //    - Sustituir únicamente la primera aparición de una letra utilizando replaceFirst().
        frase1.trim();
        System.out.println(frase1.replace('a','o'));
        System.out.println(frase1.replaceFirst("a","e"));
        // 4. Repetición del texto
        //    - Solicitar un número.
        //    - Repetir el texto introducido ese número de veces utilizando repeat().
        System.out.println("Introduce un numero:");
        int repeticiones = sc.nextInt();
        System.out.println(frase1.repeat(repeticiones));
        // 5. Extracción de texto
        //    - Mostrar los primeros cuatro caracteres utilizando substring(0, 4).
        //    - Comprobar previamente que la cadena tiene al menos cuatro caracteres.
        System.out.println(frase1.substring(0,4));
    }
}
