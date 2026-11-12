import java.util.Stack;

public class s005_LIFO {
    private static Stack<String> pila = new Stack<>();

    static void main() {
        pila.push("Plato 1");
        pila.push("Plato 2");
        pila.push("Plato 3");

        pila.addFirst("Plato 4");

        System.out.println("Pila: " + pila);

        System.out.println("Elemento superior: " + pila.peek());

        System.out.println("Pila: " + pila);

        for(String nombre: pila){
            System.out.println(nombre);
        }

        pila.pop();

        for(String nombre: pila){
            System.out.println(nombre);
        }

    }
}
