import java.util.Scanner;

public class main {
    private static Scanner sc = new Scanner(System.in);
    static void main() {
        Compra compra = new Compra();
        System.out.println("Introduzca su nombre: ");
        compra.cliente = sc.nextLine();
        System.out.println("Introduzca el nombre del producto: ");
        compra.nombreProducto = sc.nextLine();
        System.out.println("Introduzca el precio del prodcuto: ");
        compra.precio = sc.nextDouble();
        compra.toString();
        compra.aplicarDescuento();
    }
}
