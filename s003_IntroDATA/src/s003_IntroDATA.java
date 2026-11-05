import java.util.InputMismatchException;
import java.util.Scanner;

public class s003_IntroDATA {
    private static String nombre;
    private static int edad;
    private static double altura;
    private static String asignatura;
    private static int nota;
    private static Scanner sc = new Scanner(System.in);
    static void main() {
        boolean endProgram = false;
        int num;
        while(!endProgram){
            pedirDatos();
            mostrarDatos();
            System.out.println("1.Salir,2.Seguir:");
            num = sc.nextInt();
            sc.nextLine();
            endProgram = (num == 1);
        }
    }

    private static void pedirDatos(){
        boolean terminado = false;
            while(!terminado) {
                try {
                    System.out.println("Introduce tu nombre:");
                    nombre = sc.nextLine();
                    System.out.println("Introduce tu edad:");
                    edad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce tu altura:");
                    altura = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la Asignatura:");
                    asignatura = sc.nextLine();
                    System.out.println("Introduce tu nota:");
                    nota = sc.nextInt();
                    terminado = true;
                } catch (InputMismatchException e) {
                    System.err.println("Introduce un numero valido");
                    sc.nextLine();
                }
            }
    }
    private static void mostrarDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("edad: " + edad);
        System.out.println("altura: " + altura);
        System.out.println("asignatura: " + asignatura);
        System.out.println("nota: " + nota);
    }
}
