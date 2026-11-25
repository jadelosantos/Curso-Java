import java.sql.*;
import java.util.Scanner;

public class Ejercicio5 {
    private static final String url =
            "jdbc:mysql://localhost:3307/BBDD_MYSQL";
    private static final String usuario = "root";
    private static final String contrasena = "";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection conexion =
                     DriverManager.getConnection(url, usuario, contrasena)) {

            boolean salir = false;

            while (!salir) {
                System.out.println("""
                        Elige la operación:
                        1. Leer clientes
                        2. Consulta personalizada
                        3. Insertar cliente
                        4. Editar cliente
                        5. Borrar cliente
                        6. Salir
                        """);

                int operacion = Integer.parseInt(sc.nextLine());

                switch (operacion) {
                    case 1 -> leer(conexion);
                    case 2 -> busquedaPersonalizada(conexion);
                    case 3 -> insertar(conexion, pedirCliente());
                    case 4 -> editar(conexion, pedirCliente());
                    case 5 -> borrar(conexion);
                    case 6 -> salir = true;
                    default -> System.out.println("Elige una opción del 1 al 6.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Debes introducir un número válido.");
        }
    }

    private static Clientes pedirCliente() {
        Clientes cliente = new Clientes();

        System.out.print("Introduce el nombre: ");
        cliente.nombre = sc.nextLine();

        System.out.print("Introduce los apellidos: ");
        cliente.apellidos = sc.nextLine();

        System.out.print("Introduce el teléfono: ");
        cliente.telefono = sc.nextLine();

        System.out.print("Introduce el email: ");
        cliente.email = sc.nextLine();

        System.out.print("Introduce la ciudad: ");
        cliente.ciudad = sc.nextLine();

        return cliente;
    }

    private static void leer(Connection conexion) {
        String sql = "SELECT * FROM Clientes";
        boolean hayResultados = false;

        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sql)) {

            ResultSetMetaData columnas = resultado.getMetaData();

            while (resultado.next()) {
                hayResultados = true;

                for (int i = 1; i <= columnas.getColumnCount(); i++) {
                    System.out.print(columnas.getColumnLabel(i) + ": "
                            + resultado.getString(i));

                    if (i < columnas.getColumnCount()) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

            if (!hayResultados) {
                System.out.println("La tabla Clientes no contiene registros.");
            }
        } catch (SQLException e) {
            System.err.println("Error al leer los clientes: " + e.getMessage());
        }
    }

    private static void busquedaPersonalizada(Connection conexion) {
        System.out.println("Introduce una consulta SELECT:");
        String consulta = sc.nextLine();
        boolean hayResultados = false;

        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consulta)) {

            ResultSetMetaData columnas = resultado.getMetaData();

            while (resultado.next()) {
                hayResultados = true;

                for (int i = 1; i <= columnas.getColumnCount(); i++) {
                    System.out.print(columnas.getColumnLabel(i) + ": "
                            + resultado.getString(i));

                    if (i < columnas.getColumnCount()) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

            if (!hayResultados) {
                System.out.println("La consulta no devolvió resultados.");
            }
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }

    private static void insertar(Connection conexion, Clientes cliente) {
        String sql = """
                INSERT INTO Clientes (nombre, apellidos, telefono, email, ciudad)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, cliente.nombre);
            sentencia.setString(2, cliente.apellidos);
            sentencia.setString(3, cliente.telefono);
            sentencia.setString(4, cliente.email);
            sentencia.setString(5, cliente.ciudad);

            int filas = sentencia.executeUpdate();
            System.out.println("Clientes insertados: " + filas);
        } catch (SQLException e) {
            System.err.println("No se pudo insertar el cliente: " + e.getMessage());
        }
    }

    private static void editar(Connection conexion, Clientes cliente) {
        System.out.println("Introduce el ID del cliente que quieres editar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = """
                UPDATE Clientes
                SET nombre = ?, apellidos = ?, telefono = ?, email = ?, ciudad = ?
                WHERE id_cliente = ?
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, cliente.nombre);
            sentencia.setString(2, cliente.apellidos);
            sentencia.setString(3, cliente.telefono);
            sentencia.setString(4, cliente.email);
            sentencia.setString(5, cliente.ciudad);
            sentencia.setInt(6, id);

            int filas = sentencia.executeUpdate();
            System.out.println("Clientes actualizados: " + filas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo editar el cliente: " + e.getMessage());
        }
    }

    private static void borrar(Connection conexion) {
        System.out.println("Introduce el ID del cliente que quieres borrar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "DELETE FROM Clientes WHERE id_cliente = ?";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, id);

            int filas = sentencia.executeUpdate();
            System.out.println("Clientes borrados: " + filas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo borrar el cliente: " + e.getMessage());
        }
    }
}