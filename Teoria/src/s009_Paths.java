import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class s009_Paths {

    public static void main(String[] args) {
        // Crea un objeto Path que representa la ruta relativa del archivo libros.txt.
        Path ruta = Path.of("libros.txt");

        // Obtiene e imprime solo el nombre del archivo representado por la ruta.
        System.out.println("Nombre del archivo: " + ruta.getFileName());

        // Convierte la ruta relativa en una ruta absoluta y la imprime.
        System.out.println("Ruta absoluta: " + ruta.toAbsolutePath());

        // Comprueba si la ruta es absoluta e imprime "Si" o "No" segun el resultado.
        System.out.println("¿Es una ruta absoluta?" + (ruta.isAbsolute() ? "Si" : "No"));
    }
}