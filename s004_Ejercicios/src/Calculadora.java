import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    private static Scanner sc = new Scanner(System.in);
    private static int param1;
    private static int param2;
    private static int menu;

    static void main() {
        boolean endProgram = false;
        int num;
        while (!endProgram) {
            try {
                System.out.println("Introduce los numeros a operar: ");
                param1 = sc.nextInt();
                param2 = sc.nextInt();
                System.out.println("Introduce la operacion: 1.Sumar,2.Restar,3.Multiplicar,4.Dividir");
                menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        System.out.println("Resultado de la suma: " + sumar(param1, param2));
                        break;
                    case 2:
                        System.out.println("Resultado de la resta: " + restar(param1, param2));
                        break;
                    case 3:
                        System.out.println("Resultado de la multiplicacion: " + multiplicar(param1, param2));
                        break;
                    case 4:
                        System.out.println("Resultado de la division: " + dividir(param1, param2));
                        break;
                }
                System.out.println("1.Salir,2.Seguir:");
                num = sc.nextInt();
                sc.nextLine();
                endProgram = (num == 1);
            } catch (InputMismatchException e) {
                System.err.println("Introduce un numero valido");
                sc.nextLine();
            }catch (IllegalStateException e){
                System.err.println("Por favor introduzca un numero");
                sc.nextLine();
            }
        }
            sc.close();
    }

        private static int sumar ( int param1, int param2){
            return param1 + param2;
        }
        private static int restar ( int param1, int param2){
            return param1 - param2;
        }

        private static int multiplicar ( int param1, int param2){
            return param1 * param2;
        }

        private static int dividir ( int param1, int param2){
            return param1 / param2;
        }

}


