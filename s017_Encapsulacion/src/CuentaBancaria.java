public class CuentaBancaria {
    // Atributo privado
    private double saldo;
    // Constructor
    public CuentaBancaria(double saldoInicial) {
        saldo = saldoInicial;
    }
    // Getter: consultar el saldo
    public double getSaldo() {
        return saldo;
    }
    // Método para ingresar dinero
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            saldo = saldo + cantidad;
        }
    }
    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo = saldo - cantidad;
        }
    }
}
