import java.sql.*;
import java.util.Scanner;

public class Ejercicio4 {
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
                        1. Leer empleados
                        2. Consulta personalizada
                        3. Insertar empleado
                        4. Editar empleado
                        5. Borrar empleado
                        6. Salir
                        """);

                int operacion = Integer.parseInt(sc.nextLine());

                switch (operacion) {
                    case 1 -> leer(conexion);
                    case 2 -> busquedaPersonalizada(conexion);
                    case 3 -> insertar(conexion, pedirEmpleado());
                    case 4 -> editar(conexion, pedirEmpleado());
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

    private static Empresa pedirEmpleado() {
        Empresa empleado = new Empresa();

        System.out.print("Introduce el nombre: ");
        empleado.nombre = sc.nextLine();

        System.out.print("Introduce el departamento: ");
        empleado.departamento = sc.nextLine();

        System.out.print("Introduce el salario: ");
        empleado.salario = sc.nextLine();

        System.out.print("Introduce la edad: ");
        empleado.edad = sc.nextLine();

        System.out.print("Introduce la ciudad: ");
        empleado.ciudad = sc.nextLine();

        return empleado;
    }

    private static void leer(Connection conexion) {
        String sql = "SELECT * FROM Empresa";
        boolean hayResultados = false;

        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sql)) {

            ResultSetMetaData columnas = resultado.getMetaData();

            while (resultado.next()) {
                hayResultados = true;

                for (int i = 1; i <= columnas.getColumnCount(); i++) {
                    System.out.print(
                            columnas.getColumnLabel(i) + ": "
                                    + resultado.getString(i)
                    );

                    if (i < columnas.getColumnCount()) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

            if (!hayResultados) {
                System.out.println("La tabla Empresa no contiene empleados.");
            }
        } catch (SQLException e) {
            System.err.println("Error al leer los empleados: " + e.getMessage());
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
                    System.out.print(
                            columnas.getColumnLabel(i) + ": "
                                    + resultado.getString(i)
                    );

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

    private static void insertar(Connection conexion, Empresa empleado) {
        String sql = """
                INSERT INTO Empresa (nombre, departamento, salario, edad, ciudad)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, empleado.nombre);
            sentencia.setString(2, empleado.departamento);
            sentencia.setDouble(3, Double.parseDouble(empleado.salario));
            sentencia.setInt(4, Integer.parseInt(empleado.edad));
            sentencia.setString(5, empleado.ciudad);

            int filas = sentencia.executeUpdate();
            System.out.println("Empleados insertados: " + filas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo insertar el empleado: " + e.getMessage());
        }
    }

    private static void editar(Connection conexion, Empresa empleado) {
        System.out.println("Introduce el ID del empleado que quieres editar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = """
                UPDATE Empresa
                SET nombre = ?, departamento = ?, salario = ?, edad = ?, ciudad = ?
                WHERE id_empleado = ?
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, empleado.nombre);
            sentencia.setString(2, empleado.departamento);
            sentencia.setDouble(3, Double.parseDouble(empleado.salario));
            sentencia.setInt(4, Integer.parseInt(empleado.edad));
            sentencia.setString(5, empleado.ciudad);
            sentencia.setInt(6, id);

            int filas = sentencia.executeUpdate();
            System.out.println("Empleados actualizados: " + filas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo editar el empleado: " + e.getMessage());
        }
    }

    private static void borrar(Connection conexion) {
        System.out.println("Introduce el ID del empleado que quieres borrar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "DELETE FROM Empresa WHERE id_empleado = ?";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, id);

            int filas = sentencia.executeUpdate();
            System.out.println("Empleados borrados: " + filas);
        } catch (SQLException e) {
            System.err.println("No se pudo borrar el empleado: " + e.getMessage());
        }
    }
}