import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class s027_FilesCountRows {
    static void main() {
        Path archivo = Path.of("s025_mensaje.txt");
        try{
            long cantidad = Files.lines(archivo).count();
            System.out.println("Cantidad de sugerencias: " + cantidad);
        }catch (IOException e){
            System.err.println("Error leyendo archivo.");
        }
    }
}
