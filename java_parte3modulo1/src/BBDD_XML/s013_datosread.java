package BBDD_XML;

import javax.swing.*;
import java.io.*;

public class s013_datosread {
    static void main() {
        JFileChooser selector = new JFileChooser();
        boolean archivoSeleccionado = selector.showOpenDialog(null) == JFileChooser.APPROVE_OPTION;
        if (archivoSeleccionado) {
            File archivo = selector.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.err.println("No se pudo leer el archivo: " + e.getMessage());
            }
        } else {
            System.err.println("No se seleccionó ningún archivo.");
        }
    }
}
