import java.util.Scanner;

public class ComprobadorNum {
    private static Scanner sc = new Scanner(System.in);
    private static int num;
    static void main() {
        System.out.println("Introduce un numero: ");
        num = sc.nextInt();
        if(num == 0){
            System.out.println("Introduciste cero");
        }else if(num <= -1){
            System.out.println("Introduciste un numero negativo");
        }else{
            System.out.println("Introduciste un numero positivo");
        }
    }
}
