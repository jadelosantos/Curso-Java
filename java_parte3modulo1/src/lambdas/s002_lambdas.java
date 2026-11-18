package lambdas;

import java.util.ArrayList;

public class s002_lambdas {
    private static ArrayList<String> asignaturas = new ArrayList<>();
    static void main() {
        asignaturas.add("Matematicas");
        asignaturas.add("Lengua");
        asignaturas.add("Ingles");
        asignaturas.add("Programacion");
        Saludos saludo = () -> System.out.println("Bienvenido");
        saludo.saludobienvenida();
        saludo.saludodespedida();
        Operacionlambdas calcularsuma = (a, b) -> a + b;
        Operacionlambdas calcularresta = (a, b) -> a - b;
        Operacionlambdas calcularmultiplicacion = (a, b) -> a * b;
        Operacionlambdas calculardivision = (a, b) -> a / b;
        Comprobador resto = numero -> numero % 5 == 0 || numero % 3 == 0;
        Comprobador comparador = numero -> numero > 0 && numero < 100;
        ValorAbsoluto valorAbsoluto = numero -> Math.abs(numero);
        Operacionlambdas calcularArea = (a, b) -> a * b / 2;
        Operacionlambdas calcularAreaRectangulo = (a, b) -> a * b;
        Descuento descuento = (a, b) -> a - (a * b / 100.0);
        IVA iva = (a, b) -> a * (1 + b / 100.0);
        mostrarResultados(calcularsuma, calcularresta, calcularmultiplicacion, calculardivision, resto, comparador, valorAbsoluto, calcularArea, calcularAreaRectangulo, descuento, iva);

    }

    private static void mostrarResultados(Operacionlambdas calcularsuma, Operacionlambdas calcularresta, Operacionlambdas calcularmultiplicacion, Operacionlambdas calculardivision, Comprobador resto, Comprobador comparador, ValorAbsoluto valorAbsoluto, Operacionlambdas calcularArea, Operacionlambdas calcularAreaRectangulo, Descuento descuento, IVA iva) {
        System.out.println("Suma (10 + 2): " + calcularsuma.calcular(10,2));
        System.out.println("Resta (15 - 5): " + calcularresta.calcular(15,5));
        System.out.println("Multiplicación (12 * 4): " + calcularmultiplicacion.calcular(12,4));
        System.out.println("División (20 / 5): " + calculardivision.calcular(20,5));
        System.out.println("Divisible entre 3 o 5 (21): " + resto.comprobar(21));
        System.out.println("Divisible entre 3 o 5 (7): " + resto.comprobar(7));
        System.out.println("Divisible entre 3 o 5 (-15): " + resto.comprobar(-15));
        System.out.println("Está entre 1 y 99 (56): " + comparador.comprobar(56));
        System.out.println("Valor absoluto de 21: " + valorAbsoluto.calcular(21));
        System.out.println("Valor absoluto de 7: " + valorAbsoluto.calcular(7));
        System.out.println("Valor absoluto de -15: " + valorAbsoluto.calcular(-15));
        System.out.println("Área del triángulo (2, 2): " + calcularArea.calcular(2,2));
        System.out.println("Área del triángulo (2, 5): " + calcularArea.calcular(2,5));
        System.out.println("Área del triángulo (3, 15): " + calcularArea.calcular(3,15));
        System.out.println("Área del rectángulo (2, 2): " + calcularAreaRectangulo.calcular(2,2));
        System.out.println("Área del rectángulo (2, 5): " + calcularAreaRectangulo.calcular(2,5));
        System.out.println("Precio con descuento del 40% sobre 100: " + descuento.aplicar(100,40));
        System.out.println("Precio con IVA del 21% sobre 50: " + iva.aplicar(50,21));
        System.out.println("Precio con IVA del 3% sobre 50: " + iva.aplicar(50,3));
        asignaturas.forEach(asignatura -> System.out.println("Asignatura: " + asignatura));
    }
}

interface Operacionlambdas{
    int calcular(int a,int b);

}

interface Comprobador{
    boolean comprobar(int a);
}

interface ValorAbsoluto{
    int calcular(int a);
}

interface Descuento{
    double aplicar(double a,double b);
}
interface IVA{
    double aplicar(double a,double b);
}

interface Saludos{
    void saludobienvenida();

    default void saludodespedida() {
        System.out.println("Hasta pronto");
    }
}
