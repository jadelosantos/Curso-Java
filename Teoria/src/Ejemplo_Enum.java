import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Ejemplo_Enum {
    private static Scanner sc = new Scanner(System.in);
    enum EstadoCivil {
        SOLTERO,
        CASADO,
        DIVORCIADO,
        VIUDO
    }

    static void main() {
        System.out.println("====================");
        System.out.println("=== ESTADO CIVIL ===");
        System.out.println("====================");
        System.out.println("1. SOLTERO");
        System.out.println("2. CASADO");
        System.out.println("3. DIVORCIADO");
        System.out.println("4. VIUDO");
        System.out.println("====================");
        System.out.println("Selecciona una opcion: ");
        int opcion = sc.nextInt();
        EstadoCivil estado = null;
        switch (opcion){
            case 1:
                estado = EstadoCivil.SOLTERO;
                break;
        }
        System.out.println("Tu estado civil es: " + estado);
    }
}
