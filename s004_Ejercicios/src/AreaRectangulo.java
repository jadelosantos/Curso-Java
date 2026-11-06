import java.util.Scanner;

public class AreaRectangulo {
    private static Scanner sc = new Scanner(System.in);
    private static int base;
    private static int altura;

    static void main() {
        System.out.println("Introduce la base: ");
        base = sc.nextInt();
        System.out.println("Introduce la altura: ");
        altura = sc.nextInt();
        System.out.println(base*altura + " m2");
    }
}
