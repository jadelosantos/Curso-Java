import java.util.InputMismatchException;
import java.util.Scanner;

public class s002_Ejercicio {
    private static Scanner sc = new Scanner(System.in);
    private static String NomAlum;
    private static int NotaAlum;

    public static void main(String[] args) {
        // Almacenar una nota
        // Averiguar si es mayor que 5
        // Saber si el alumno ha aprobado
        while (true) {
            try {
                System.out.println("Introduce el nombre del alumno:");
                NomAlum = sc.nextLine();
                System.out.println("Introduzca la nota del alumno: ");
                NotaAlum = sc.nextInt();
                if (NomAlum.isEmpty()) {
                    System.err.println("Por favor introduzca un nombre para el alumno");
                } else if (NotaAlum >= 5) {
                    System.out.println("El alumno " + NomAlum + " ha aprobado");
                    sc.nextLine();
                } else {
                    System.out.println("El alumno " + NomAlum + " ha suspendido");
                    sc.nextLine();
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Debes introducir un numero en la nota del alumno");
                sc.nextLine();
            }

        }
    }
}