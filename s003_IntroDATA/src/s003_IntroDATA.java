import java.util.InputMismatchException;
import java.util.Scanner;

public class s003_IntroDATA {
    private static String nombre;
    private static int edad;
    private static double altura;
    private static String asignatura;
    private static int nota;
    private static Scanner sc = new Scanner(System.in);
    private static double edadMedia = 1.76;
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
        System.out.println("Edad: " + edad);
        System.out.println(edad >= 18 ? "Es mayor de edad" : "Es menor de edad");
        System.out.println("altura: " + altura);
        System.out.println(altura > edadMedia ? "Tienes una altura superior a la media" : "Tienes una altura menor a la media");
        System.out.println("asignatura: " + asignatura);
        System.out.println("nota: " + nota);
        System.out.println(nota >= 5 ? "Aprobado" : "Suspenso");
    }
}
