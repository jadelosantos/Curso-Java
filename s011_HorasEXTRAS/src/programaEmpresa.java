import java.util.Scanner;

public class programaEmpresa {
    private static Scanner sc = new Scanner(System.in);
    private static boolean endProgram = false;
    private static String nomEmpleado;
    private static int horasExtrasEmpleado;
    private static double precioHoraEmpleado;
    private static int num;
    static void main() {
        do {
            System.out.println("Introduce el nombre del empleado:");
            nomEmpleado = sc.nextLine();
            System.out.println("Introduce las horas extras del empleado:");
            horasExtrasEmpleado = sc.nextInt();
            System.out.println("Introduce el precio/hora del empleado");
            precioHoraEmpleado = sc.nextDouble();
            Empleado empleado = new Empleado(nomEmpleado,horasExtrasEmpleado,precioHoraEmpleado);
            empleado.mostrarDatos();
            empleado.plusHoras();
            System.out.println("1.Crear Otro empleado");
            System.out.println("2.Salir");
            num = sc.nextInt();
            if(num == 0){
                endProgram = true;
            }
        }while (!endProgram);
    }
}
