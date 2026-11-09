import java.util.Scanner;

class Alumno{
    String nombre;
    int edad;
    double nota;

    void mostrarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Nota: " + nota);
    }

    boolean haAprobado(double nota){
        return nota>=5;
    }

    }

public class s010_POOExcercise1 {
    private static Scanner sc = new Scanner(System.in);
    static void main() {
        Alumno alumno = new Alumno();
        System.out.println("Introduzca el nombre del alumno: ");
        alumno.nombre = sc.nextLine();
        System.out.println("Introduzca la edad del alumno: ");
        alumno.edad = sc.nextInt();
        System.out.println("Introduzca la nota del alumno: ");
        alumno.nota = sc.nextDouble();
        alumno.mostrarInformacion();
        System.out.println(alumno.haAprobado(alumno.nota) ? "El alumno " + alumno.nombre + " ha aprobado" : "El alumno " + alumno.nombre + " ha suspendido");
    }
}
