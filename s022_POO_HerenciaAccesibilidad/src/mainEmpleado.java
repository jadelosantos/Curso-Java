import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mainEmpleado {
    private static Scanner sc = new Scanner(System.in);
    private static String nombreEmpleado;
    private static String dniEmpleado;
    private static double sueldoEmpleado;
    private static String nombreEmpresa;
    private static boolean endprogram = false;
    private static boolean terminaEnLetra;

    static void main() {
        do {
            try {
                pedirDatos();
                int num = sc.nextInt();
                switch (num){
                   case 1:
                       sc.nextLine();
                        System.out.println("Introduzca las campanas");
                        int campanasEmpleado = sc.nextInt();
                        EmpleadoMarketing empleadoMarketing = new EmpleadoMarketing(nombreEmpleado,dniEmpleado,sueldoEmpleado,nombreEmpresa,campanasEmpleado);
                       System.out.println(empleadoMarketing);
                       break;
                    case 2:
                        sc.nextLine();
                        String especialidadEmpleado;
                        String lenguajeProgramacionEmpleado;
                        System.out.println("Introduce la especialidad del Empleado: ");
                        especialidadEmpleado = sc.nextLine();
                        System.out.println("Introduce el lenguaje de programacion en el que se especializa el empleado: ");
                        lenguajeProgramacionEmpleado = sc.nextLine();
                        EmpleadoInformatica empleadoInformatica = new EmpleadoInformatica(nombreEmpleado,dniEmpleado,sueldoEmpleado,nombreEmpresa,especialidadEmpleado,lenguajeProgramacionEmpleado);
                        System.out.println(empleadoInformatica);
                        break;
                    case 3:
                        sc.nextLine();
                        int contrataciones;
                        System.out.println("Introduzca las contrataciones del empleado");
                        contrataciones = sc.nextInt();
                        EmpleadoRRHH empleadoRRHH = new EmpleadoRRHH(nombreEmpleado,dniEmpleado,sueldoEmpleado,nombreEmpresa,contrataciones);
                        System.out.println(empleadoRRHH);
                        break;
                }
                System.out.println("1.Salir");
                System.out.println("2.Crear otro empleado");
                int menu = sc.nextInt();
                sc.nextLine();
                endprogram = (menu == 1);
                System.out.println(endprogram ? "Saliendo..." : "");
            } catch (InputMismatchException e) {
                System.err.println("Introduce un numero valido");
                sc.nextLine();
            }
        }while(!endprogram);
    }

    private static void pedirDatos() {
        System.out.println("Introduce el nombre del empleado:");
        nombreEmpleado = sc.nextLine();
        do {
            System.out.println("Introduce el DNI del empleado:");
            dniEmpleado = sc.nextLine();

            terminaEnLetra = !dniEmpleado.isEmpty()
                    && Character.isLetter(dniEmpleado.charAt(dniEmpleado.length() - 1));

            if (!terminaEnLetra) {
                System.err.println("El DNI debe terminar en una letra.");
            }
        } while (!terminaEnLetra);
        System.out.println("Introduzca el salario del empleado:");
        sueldoEmpleado = sc.nextDouble();
        sc.nextLine();
        System.out.println("Introduzca el nombre de la empresa:");
        nombreEmpresa = sc.nextLine();
        System.out.println("¿De que departamento forma parte el empleado?");
        System.out.println("1.Marketing");
        System.out.println("2.Informatica");
        System.out.println("3.Recursos Humanos");
    }
}
