import java.util.InputMismatchException;
import java.util.Scanner;

public class RectanguloMain {
    private static Scanner sc = new Scanner(System.in);
    private static double base;
    private static double altura;
    private static double lado1 = 30;
    private static double lado2 = 40;
    private static double lado3 = 50;
    private static double lado4 = 60;
    private static boolean endProgram = false;
    private static double area;
    private static double perimetro;
    static void main(String[] args) {
        do {
            try {
                System.out.println("Introduce la base del rectangulo: ");
                base = sc.nextDouble();
                System.out.println("Introduce el area del rectangulo: ");
                altura = sc.nextDouble();
                Rectangulo rectangulo = new Rectangulo(base,altura);
                System.out.println("1.Calcular el area");
                System.out.println("2.Calcular el perimetro");
                int opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        area = rectangulo.calcularArea();
                        break;
                    case 2:
                        perimetro = rectangulo.calcularPerimetro();
                        break;
                }
                rectangulo.mostrarDatos(area,perimetro);
                System.out.println("1.Calcular otro rectangulo");
                System.out.println("2.Salir");
                int opcion2 = sc.nextInt();
                if(opcion2 == 2){
                    endProgram = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Introduce un numero valido");
            }
        }while (!endProgram);
    }
}
