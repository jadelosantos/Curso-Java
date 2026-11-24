import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PruebaJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/escuela";
        String usuario = "root";
        String contrasena = "";

        try (Connection conexion =
                     DriverManager.getConnection(url, usuario, contrasena);
             Statement consulta = conexion.createStatement();
             ResultSet resultado = consulta.executeQuery("SELECT 1")) {

            if (resultado.next()) {
                System.out.println("Conexión JDBC correcta: " + resultado.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar:");
            e.printStackTrace();
        }
    }
}