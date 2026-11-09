public class Calculadora {
    public void sumar(double num1,double num2){
        double resultado = num1 + num2;
        System.out.println("La suma es: " + resultado);
    }
    public void restar(double num1,double num2){
        double resultado = num1 - num2;
        System.out.println("La resta es: " + resultado);
    }
    public void multiplicar(double num1,double num2){
        double resultado = num1 * num2;
        System.out.println("La multiplicacion es: " + resultado);
    }
    public void dividir(double num1,double num2){
        double resultado = 0;
        if (num1 > 0 && num2 > 0) {
            resultado = num1 / num2;
        }else{
            System.err.println("No es posible dividir entre cero");
        }
        System.out.println("La division es: " + resultado);
    }
}
