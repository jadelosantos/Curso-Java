import java.util.Scanner;

public class s014_POO_main {
    private static Scanner sc = new Scanner(System.in);

    static void main() {

        System.out.println("Introduce tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce tu Edad: ");
        int edad = sc.nextInt();
        s014_POO persona = new s014_POO(nombre,edad);
        persona.saludar();
    }
}
