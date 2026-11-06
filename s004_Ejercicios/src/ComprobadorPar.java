import java.util.Scanner;

public class ComprobadorPar {
    private static Scanner sc = new Scanner(System.in);
    private static int num;
    static void main() {
        System.out.println("Introduce un numero: ");
        num = sc.nextInt();
        System.out.println(num % 2 == 0 ? "Es par" : "Es impar");
    }
}
