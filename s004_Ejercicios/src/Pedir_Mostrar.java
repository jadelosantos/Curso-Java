import java.util.Scanner;

public class Pedir_Mostrar {
    private static Scanner sc = new Scanner(System.in);
    private static int num;
    static void main() {
        System.out.println("Introduce un numero: ");
        num = sc.nextInt();
        System.out.println("Introduciste el numero: " + num);
    }
}
