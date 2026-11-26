import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class s033_HashMapScanner {
    private static HashMap<String,Double> notas = new HashMap<>();
    private static boolean endprogram = false;
    private static Scanner sc = new Scanner(System.in);
    private static String nombreConsola;
    static void main() {
        notas.put("Ana",8.5);
        notas.put("Carlos",6.0);
        notas.put("Maria",9.2);
        notas.put("Pedro",4.5);
        notas.put("Laura",7.8);

        do {
            System.out.print("""
                    1.Mostrar Alumnos y sus notas
                    2.Consultar la nota del alumno introducido por teclado
                    3.Modificar la nota de un alumno
                    4.Comprobar si el alumno introducido por teclado esta suspenso
                    5.Eliminar un alumno introducido por teclado
                    Pulsa cualquier numero para salir
                    """);
            int opcion = sc.nextInt();
            switch (opcion){
                case 1 -> {
                    for (Map.Entry<String,Double> nota : notas.entrySet()){
                        System.out.println(nota.getKey() + " " + nota.getValue());
                    }
                    System.out.println();
                }
                case 2 -> {
                    sc.nextLine();
                    System.out.println("Introduce el nombre del alumno a buscar: ");
                    nombreConsola = sc.nextLine();
                    System.out.println();
                    System.out.println(notas.containsKey(nombreConsola) ? notas.get(nombreConsola) : "\u001B[31mNo existe un alumno con ese nombre\u001B[0m");
                    System.out.println();
                }
                case 3 -> {
                    sc.nextLine();
                    System.out.println("Introduce el nombre del alumno a modificar: ");
                    nombreConsola = sc.nextLine();
                    System.out.println("Introduce la nueva nota del alumno:");
                    double notaNueva = sc.nextDouble();
                    sc.nextLine();
                    if (notas.containsKey(nombreConsola)) {
                        notas.put(nombreConsola, notaNueva);
                        System.out.println();
                        System.out.println("\u001B[32mAlumno modificado correctamente\u001B[0m");
                    }else{
                        System.out.println("\u001B[31mNo existe un alumno con ese nombre\u001B[0m");
                    }
                    System.out.println();
                }

                case 4 ->{
                    sc.nextLine();
                    System.out.println("Introduce el nombre del alumno a comprobar: ");
                    nombreConsola = sc.nextLine();
                    System.out.println();
                    if(notas.containsKey(nombreConsola)){
                        System.out.println(notas.get(nombreConsola) >= 5 ? "\u001B[32mAlumno aprobado\u001B[0m"  : "\u001B[31mAlumno suspenso\u001B[0m");
                        System.out.println();
                    }
                }

                case 5 -> {
                    sc.nextLine();
                    System.out.println("Introduce el nombre del alumno a eliminar: ");
                    nombreConsola = sc.nextLine();
                    System.out.println(notas.containsKey(nombreConsola) ? notas.remove(nombreConsola) : "\u001B[31mNo existe un alumno con ese nombre\u001B[0m");
                    System.out.println();
                    System.out.println("\u001B[32mAlumno eliminado correctamente\u001B[0m");
                    System.out.println();
                }

                case 6 -> endprogram = true;
            }
        } while (!endprogram);


    }

}
