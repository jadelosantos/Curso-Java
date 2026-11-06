import java.util.Scanner;

public class AreaCuadrado {
    private static final int lados = 4;
    private static Scanner sc = new Scanner(System.in);
    private static int longitudLado;
    static void main() {
        System.out.println("Introduce la longitud del lado: ");
        longitudLado = sc.nextInt();
        System.out.println(longitudLado*lados + " m2");
    }
}
