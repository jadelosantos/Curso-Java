/*

Enunciado
Desarrolla una aplicación Java que permita almacenar alumnos y sus notas utilizando un HashMap.

Requisitos:
Crear un HashMap donde la clave sea el nombre del alumno y el valor su nota.
Introducir cinco alumnos.
Mostrar todos los alumnos y sus notas.
Buscar la nota de un alumno concreto.
Comprobar si existe un alumno llamado Antonio.
Mostrar el número total de alumnos.*/

import java.util.HashMap;
import java.util.Map;

public class s021_EjercicioHashMap1 {
    private static HashMap<String,Double> alumnos = new HashMap<>();
    private static HashMap<String,Integer> productos = new HashMap<>();

    static void main() {

        alumnos.put("Antonio", 8.5);
        alumnos.put("Maria", 9.0);
        alumnos.put("Pedro", 6.5);
        alumnos.put("Lucia", 7.5);
        alumnos.put("Carlos", 5.0);

        productos.put("raton", 5);
        productos.put("teclado", 10);
        productos.put("monitor", 23);
        productos.put("torre", 12);
        productos.put("auriculares", 4);

        System.out.println("Listado de alumnos");
        for (Map.Entry<String,Double> alumno : alumnos.entrySet()){
            System.out.println(alumno.getKey() + " - " + alumno.getValue());
        }

        System.out.println("\nNota de maria:" +
                alumnos.get("Maria"));

        if (alumnos.containsKey("Antonio")){
            System.out.println("Antonio esta registrado");
        }

        System.out.println("Total alumnos:" + alumnos.size());


        System.out.println("Listado de productos");
        for (Map.Entry<String,Integer> producto : productos.entrySet()){
            System.out.println(producto.getKey() + " - " + producto.getValue());
        }

        System.out.println("Unidades disponibles de monitores:" +
                productos.get("raton"));
        productos.put("raton",15);
        productos.remove("monitor");


        System.out.println("Listado de productos");
        for (Map.Entry<String,Integer> producto : productos.entrySet()){
            System.out.println(producto.getKey() + " - " + producto.getValue());
        }
    }

}
