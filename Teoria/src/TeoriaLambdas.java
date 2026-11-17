import java.util.ArrayList;

public class TeoriaLambdas {
    static void main() {
        Saludo saludo = () -> System.out.println("Hola, estamos aprendiendo java");
        saludo.saludar();

        Operacion calcularArea = (a,b) -> a * b;
        int resultado = calcularArea.calcular(10,20);
        System.out.println("Resultado: " + resultado);

        Comprobador par = numero -> numero % 2 == 0;

        System.out.println(par.comprobar(8));
        System.out.println(par.comprobar(15));

        Comprobador mayorEdad =numero -> numero >= 18;

        System.out.println(mayorEdad.comprobar(14));

        Transformador mayusculas = texto -> texto.toUpperCase();

        System.out.println(mayusculas.transformar("minuscula"));

        ArrayList<String> alumnos = new ArrayList<>();

        alumnos.add("Ana");
        alumnos.add("Pedro");
        alumnos.add("Maria");
        alumnos.add("Carlos");
        alumnos.add("Laura");

        alumnos.stream().forEach(System.out::println);
    }
}
    @FunctionalInterface interface Saludo{
        void saludar();
    }

    interface Operacion{
        int calcular (int a, int b);
    }

    interface Comprobador{
        boolean comprobar(int numero);
    }

    interface Transformador {
        String transformar(String texto);
    }