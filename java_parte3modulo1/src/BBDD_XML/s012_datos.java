package BBDD_XML;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class s012_datos {
    private static String nombre;
    private static String apellidos;
    private static String sugerencia;
    private static Scanner sc = new Scanner(System.in);
    static void main(String[] args) {
        try {
            FileWriter file = new FileWriter("politicasCOOKIES.txt");
            BufferedWriter datos = new BufferedWriter(file);
            System.out.println("Introduce tu nombre: ");
            nombre = sc.nextLine();
            System.out.println("Introduce tus apellidos: ");
            apellidos = sc.nextLine();
            apellidos.trim();
            System.out.println("Introduce tu sugerencia:");
            sugerencia = sc.nextLine();
            datos.write("Nombre: " + nombre + System.lineSeparator() + "Apellidos: " + apellidos + System.lineSeparator() + "Sugerencia: " + sugerencia);
            datos.close();
            file.close();
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al crear el archivo: " + e.getMessage());
        }
    }
}
