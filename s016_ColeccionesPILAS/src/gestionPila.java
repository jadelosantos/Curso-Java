import java.util.Stack;

public class gestionPila {
    private static Stack<Integer> pila = new Stack<>();
    private static int sumTotal;

    static void main() {
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);
        pila.push(50);

        for(int num:pila){
            System.out.println("Numero: " + num);
            sumTotal += num;
        }

        System.out.println("Numero mas alto de la lista: " + pila.peek());
        pila.remove(2);
        pila.remove(3);
        System.out.println("Tamaño de la lista: " + pila.size());
        System.out.println("Suma de todos los numeros: " + sumTotal);

    }
}
