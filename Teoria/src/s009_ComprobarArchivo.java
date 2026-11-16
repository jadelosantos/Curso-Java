import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class s009_ComprobarArchivo {
    static void main() {
        Path ruta = Path.of("libros.txt");
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea: lineas){
                System.out.println(linea);
            }
        }catch (IOException e){
            System.err.println("No se pudo leer el archivo: " + e.getLocalizedMessage());
        }
    }
}
