import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    private static Scanner sc = new Scanner(System.in);
    static void main() {
        Compra compra = new Compra();
        try {
            System.out.println("Introduzca su nombre: ");
            compra.cliente = sc.nextLine();
            System.out.println("Introduzca el nombre del producto: ");
            compra.nombreProducto = sc.nextLine();
            System.out.println("Introduzca el precio del prodcuto: ");
            compra.precio = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("Introduce un numero valido");
        }
        compra.toString();
        compra.aplicarDescuento();
    }
}
