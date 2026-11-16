public class s001_Lambda {

    static void main() {
        Operacion suma = (a,b) -> a + b;
        Operacion resta = (a,b) -> a - b;

        System.out.println("Suma: " + suma.calcular(10,5));

    }

    interface Operacion{
        int calcular(int a, int b);
    }
}
