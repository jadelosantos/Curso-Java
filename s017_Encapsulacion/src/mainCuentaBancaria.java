public class mainCuentaBancaria {
    static void main() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        System.out.println(cuenta.getSaldo());
        cuenta.ingresar(500);
        cuenta.retirar(200);
        System.out.println(cuenta.getSaldo());
    }
}
