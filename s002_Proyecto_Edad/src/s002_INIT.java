import java.util.Scanner;

public class s002_INIT {
    private static Scanner sc = new Scanner(System.in);
    private static String nombre;
    private static int edad;
    static void main() {
        System.out.println("Introduce tu nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce tu edad: ");
        edad = sc.nextInt();
//        if(edad >= 18){
//            System.out.println("Eres mayor de edad");
//        }else{
//            System.err.println("No eres mayor de edad");
//        }
        //IF ternario
        System.out.println(edad >= 18 ? nombre + " es mayor de edad" : nombre + " es menor de edad" );
    }
}
