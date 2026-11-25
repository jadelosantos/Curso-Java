import java.sql.*;
import java.util.Scanner;

public class Ejercicio3 {
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
                        1. Leer alumnos
                        2. Consulta personalizada
                        3. Insertar alumno
                        4. Editar alumno
                        5. Borrar alumno
                        6. Salir
                        """);

                int operacion = Integer.parseInt(sc.nextLine());

                switch (operacion) {
                    case 1 -> leer(conexion);
                    case 2 -> busquedaPersonalizada(conexion);
                    case 3 -> insertar(conexion, pedirAlumno());
                    case 4 -> editar(conexion, pedirAlumno());
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

    private static CentroEducativo pedirAlumno() {
        CentroEducativo alumno = new CentroEducativo();

        System.out.print("Introduce el nombre: ");
        alumno.nombre = sc.nextLine();

        System.out.print("Introduce los apellidos: ");
        alumno.apellidos = sc.nextLine();

        System.out.print("Introduce la edad: ");
        alumno.edad = sc.nextLine();

        System.out.print("Introduce el curso: ");
        alumno.curso = sc.nextLine();

        System.out.print("Introduce la nota: ");
        alumno.nota = sc.nextLine();

        return alumno;
    }

    private static void leer(Connection conexion) {
        String sql = "SELECT * FROM CentroEducativo";
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
                System.out.println("La tabla CentroEducativo no contiene alumnos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al leer los alumnos: " + e.getMessage());
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

    private static void insertar(Connection conexion, CentroEducativo alumno) {
        String sql = """
                INSERT INTO CentroEducativo
                    (nombre, apellidos, edad, curso, nota)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, alumno.nombre);
            sentencia.setString(2, alumno.apellidos);
            sentencia.setInt(3, Integer.parseInt(alumno.edad));
            sentencia.setString(4, alumno.curso);
            sentencia.setDouble(5, Double.parseDouble(alumno.nota));

            int filas = sentencia.executeUpdate();
            System.out.println("Alumnos insertados: " + filas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo insertar el alumno: " + e.getMessage());
        }
    }

    private static void editar(Connection conexion, CentroEducativo alumno) {
        System.out.println("Introduce el ID del alumno que quieres editar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = """
                UPDATE CentroEducativo
                SET nombre = ?, apellidos = ?, edad = ?, curso = ?, nota = ?
                WHERE id_alumno = ?
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, alumno.nombre);
            sentencia.setString(2, alumno.apellidos);
            sentencia.setInt(3, Integer.parseInt(alumno.edad));
            sentencia.setString(4, alumno.curso);
            sentencia.setDouble(5, Double.parseDouble(alumno.nota));
            sentencia.setInt(6, id);

            int filas = sentencia.executeUpdate();
            System.out.println("Alumnos actualizados: " + filas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo editar el alumno: " + e.getMessage());
        }
    }

    private static void borrar(Connection conexion) {
        System.out.println("Introduce el ID del alumno que quieres borrar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "DELETE FROM CentroEducativo WHERE id_alumno = ?";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, id);

            int filas = sentencia.executeUpdate();
            System.out.println("Alumnos borrados: " + filas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo borrar el alumno: " + e.getMessage());
        }
    }
}