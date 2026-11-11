import java.util.Scanner;

public class mainAlumno {
    private static Scanner sc = new Scanner(System.in);
    private static String nombreAlumno;
    private static int notaAlumno;
    private static boolean endProgram = false;
    public static void main(String[] args) {
        do {
            System.out.println("Introduce el nombre del alumno:");
            nombreAlumno = sc.nextLine();
            System.out.println( "Introduce la nota del alumno:");
            notaAlumno = sc.nextInt();
            Alumno alumno = new Alumno();
            alumno.setNombre(nombreAlumno);
            alumno.setNota(notaAlumno);
            alumno.mostrarResultado();
            System.out.println("1.Salir");
            System.out.println("2.Comprobar otro alumno");
            int num = sc.nextInt();
            if(num == 1){
                endProgram = true;
            }
        }while(!endProgram);
    }
}