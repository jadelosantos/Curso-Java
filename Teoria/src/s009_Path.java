import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class s009_Path {

    public static void main(String[] args) {
        Path archivo = Path.of("libros.txt");
        try {
            Files.writeString(
                    archivo,
                    "El Quijote;Miguel de Cervantes"
            );
            System.out.println("Libro guardado.");
        } catch (IOException e) {
            System.out.println(
                    "No se pudo guardar el archivo: "
                            + e.getMessage()
            );
        }
    }
}
