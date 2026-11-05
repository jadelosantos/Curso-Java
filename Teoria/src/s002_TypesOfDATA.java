import java.util.Date;
import java.util.Scanner;

public class s002_TypesOfDATA {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // byte
        // Almacena números enteros pequeños
        // -128 hasta 127
        byte menor = 112;
        System.out.println("Número de alumnos " + menor);

        // short
        // Almacena números enteros desde -32.768 hasta 32.767
        short productos = 15000;
        System.out.println("Productos disponibles " + productos);

        // int
        // Uno de los tipos más utilizados para almacenar números enteros
        // desde -2.147.483.648 hasta 2.147.483.647
        int edad = 30;
        System.out.println("Edad del cliente " + edad);

        // double
        // Almacena números decimales con mayor precisión que float
        double distancia = 125.6789;
        System.out.println("Distancia recorrida: " + distancia + " km");

        // string
        // Almacena una cadena de caracteres, es decir, texto.
        String nombre = "Carlos";

        // char
        // Almacena un único carácter, como una letra, un dígito o un símbolo.
        char nota = 'A';
        System.out.println("Nota del alumno " + nota);

        // boolean
        boolean aprobado = true;
        System.out.println("¿Ha aprobado el alumno? " + aprobado);

        //Convertir String a Integer
        Integer num2 = Integer.valueOf("100");
        System.out.println("Valor : " + num2);
        String num3 = "150";
        Integer num4 = Integer.valueOf(num3);
        System.out.println("Valor : " + num2);

        //Abreviacion de operaciones
        num4 *= 2;
        num4++;
        num4 += 80;

        //Obtener el valor como un entero
        int resultnum = num4.intValue();

        //Ejemplo Integerparseint
        String texto = "50";
        int numero = Integer.parseInt(texto);
        System.out.println("Numero: " + numero);

        //Ejemplo suma
        String numero2 = "25.75";
        numero2 += 50;
        double resultado = Double.parseDouble(numero2);
        System.out.println(numero2);

        //Ejemplo fecha
        Date fechaActual = new Date();
        System.out.println("Fecha actual: " + fechaActual);

        //Ejemplo Scanner
        System.out.println("Introduce tu edad: ");
        String textosc = sc.nextLine();
        int edadsc = Integer.parseInt(textosc);
        System.out.println("Tu edad es :" + edadsc);
        sc.close();

        System.out.println("Introduce tu nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce tu nota: ");
        int notasc = sc.nextInt();
        if(notasc >= 5){
            System.out.println("El alumno " + nombre + " ha aprobado");
        }else{
            System.out.println("El alumno " + nombre + " ha suspendido");
        }
        // Ejemplo booleano guardando expresion condicional
        // aprobado = (nota > 5);
        //Ejemplo equals
        String nombreAlumno1 = "Miguel";
        String nombreAlumno2 = "Rafael";
        if(nombreAlumno1.equals(nombreAlumno2)){
            System.out.println("iguales");
        }
    }
}
