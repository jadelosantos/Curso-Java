import java.util.Scanner;
import java.util.Stack;

public class Pila_Nombres {
    private static Stack<String> pila = new Stack<>();
    private static Scanner sc = new Scanner(System.in);

    static void main() {
        pila.push("Nombre 1");
        pila.push("Nombre 2");
        pila.push("Nombre 3");
        pila.push("Nombre 4");
        pila.push("Nombre 5");

        for(String nombre: pila){
            System.out.println("Nombre :" + nombre);
        }

        pila.peek();
        pila.pop();
        System.out.println(pila);
    }
}
