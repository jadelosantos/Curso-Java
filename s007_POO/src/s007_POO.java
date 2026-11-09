import java.util.Scanner;

class CuentaBancaria{
    String titular;
    double saldo;

    void ingresar(double cantidad){
        if(cantidad > 0){
            saldo += cantidad;
        }else{
            System.err.println("Introduce una cantidad positiva");
        }
    }

    void retirar(double cantidad){
        if(cantidad > 0){
            saldo -= cantidad;
        }else{
            System.err.println("Introduce una cantidad positiva");
        }
    }

    void consultarSaldo(){
        System.out.println("Saldo actual: " + saldo);
    }


}

public class s007_POO {
    private static Scanner sc = new Scanner(System.in);
    private static int num;
    private static boolean endProgram = false;
    static void main() {
        CuentaBancaria cuentab = new CuentaBancaria();
        System.out.println("Introduce el titular de la cuenta: ");
        cuentab.titular = sc.nextLine();
        System.out.println("Introduce el saldo de la cuenta:");
        cuentab.saldo = sc.nextDouble();
        do {
            endProgram = menu(cuentab, endProgram);
        }while (!endProgram);
    }

    private static boolean menu(CuentaBancaria cuentab, boolean endProgram) {
        System.out.println("1.Ingresar");
        System.out.println("2.Retirar");
        System.out.println("3.Consultar Saldo");
        System.out.println("4.Salir");
        num = sc.nextInt();
        switch (num){
            case 1:
                System.out.println("Introduce la cantidad a ingresar:");
                double cantidadIngreso = sc.nextDouble();
                cuentab.ingresar(cantidadIngreso);
                break;
            case 2:
                System.out.println("Introduce la cantidad a Retirar: ");
                double cantidadRetiro = sc.nextDouble();
                cuentab.retirar(cantidadRetiro);
                break;
            case 3:
                cuentab.consultarSaldo();
                break;
            case 4:
                endProgram = true;
                break;
        }
        return endProgram;
    }
}
