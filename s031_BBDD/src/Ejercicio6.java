import java.sql.*;
import java.util.Scanner;

public class Ejercicio6 {
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
                        2. Leer cursos
                        3. Consulta personalizada
                        4. Insertar alumno
                        5. Editar alumno
                        6. Borrar alumno
                        7. Insertar curso
                        8. Editar curso
                        9. Borrar curso
                        10. Salir
                        """);

                int operacion = Integer.parseInt(sc.nextLine());

                switch (operacion) {
                    case 1 -> leer(conexion, "Alumnos");
                    case 2 -> leer(conexion, "Curso");
                    case 3 -> busquedaPersonalizada(conexion);
                    case 4 -> insertarAlumno(conexion, pedirAlumno());
                    case 5 -> editarAlumno(conexion, pedirAlumno());
                    case 6 -> borrarAlumno(conexion);
                    case 7 -> insertarCurso(conexion, pedirCurso());
                    case 8 -> editarCurso(conexion, pedirCurso());
                    case 9 -> borrarCurso(conexion);
                    case 10 -> salir = true;
                    default -> System.out.println("Elige una opción del 1 al 10.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Debes introducir un número válido.");
        }
    }

    private static Alumnos pedirAlumno() {
        Alumnos alumno = new Alumnos();

        System.out.print("Introduce el nombre: ");
        alumno.nombre = sc.nextLine();

        System.out.print("Introduce los apellidos: ");
        alumno.apellidos = sc.nextLine();

        System.out.print("Introduce la edad: ");
        alumno.edad = sc.nextLine();

        return alumno;
    }

    private static Curso pedirCurso() {
        Curso curso = new Curso();

        System.out.print("Introduce el nombre del curso: ");
        curso.nombre_curso = sc.nextLine();

        System.out.print("Introduce la duración: ");
        curso.duracion = sc.nextLine();

        System.out.print("Introduce el precio: ");
        curso.precio = sc.nextLine();

        System.out.print("Introduce el ID del alumno: ");
        curso.id_alumno = sc.nextLine();

        return curso;
    }

    private static void leer(Connection conexion, String tabla) {
        String sql = "SELECT * FROM " + tabla;
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
                System.out.println("La tabla " + tabla + " no contiene registros.");
            }
        } catch (SQLException e) {
            System.err.println("Error al leer " + tabla + ": " + e.getMessage());
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

    private static void insertarAlumno(Connection conexion, Alumnos alumno) {
        String sql = """
                INSERT INTO Alumnos (nombre, apellidos, edad)
                VALUES (?, ?, ?)
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, alumno.nombre);
            sentencia.setString(2, alumno.apellidos);
            sentencia.setInt(3, Integer.parseInt(alumno.edad));

            int filas = sentencia.executeUpdate();
            System.out.println("Alumnos insertados: " + filas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo insertar el alumno: " + e.getMessage());
        }
    }

    private static void editarAlumno(Connection conexion, Alumnos alumno) {
        System.out.println("Introduce el ID del alumno que quieres editar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = """
                UPDATE Alumnos
                SET nombre = ?, apellidos = ?, edad = ?
                WHERE id_alumno = ?
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, alumno.nombre);
            sentencia.setString(2, alumno.apellidos);
            sentencia.setInt(3, Integer.parseInt(alumno.edad));
            sentencia.setInt(4, id);

            System.out.println("Alumnos actualizados: " + sentencia.executeUpdate());
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo editar el alumno: " + e.getMessage());
        }
    }

    private static void borrarAlumno(Connection conexion) {
        System.out.println("Introduce el ID del alumno que quieres borrar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "DELETE FROM Alumnos WHERE id_alumno = ?";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, id);
            System.out.println("Alumnos borrados: " + sentencia.executeUpdate());
        } catch (SQLException e) {
            System.err.println("No se pudo borrar el alumno: " + e.getMessage());
        }
    }

    private static void insertarCurso(Connection conexion, Curso curso) {
        String sql = """
                INSERT INTO Curso (nombre_curso, duracion, precio, id_alumno)
                VALUES (?, ?, ?, ?)
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, curso.nombre_curso);
            sentencia.setInt(2, Integer.parseInt(curso.duracion));
            sentencia.setDouble(3, Double.parseDouble(curso.precio));
            sentencia.setInt(4, Integer.parseInt(curso.id_alumno));

            int filas = sentencia.executeUpdate();
            System.out.println("Cursos insertados: " + filas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo insertar el curso: " + e.getMessage());
        }
    }

    private static void editarCurso(Connection conexion, Curso curso) {
        System.out.println("Introduce el ID del curso que quieres editar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = """
                UPDATE Curso
                SET nombre_curso = ?, duracion = ?, precio = ?, id_alumno = ?
                WHERE id_curso = ?
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, curso.nombre_curso);
            sentencia.setInt(2, Integer.parseInt(curso.duracion));
            sentencia.setDouble(3, Double.parseDouble(curso.precio));
            sentencia.setInt(4, Integer.parseInt(curso.id_alumno));
            sentencia.setInt(5, id);

            System.out.println("Cursos actualizados: " + sentencia.executeUpdate());
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo editar el curso: " + e.getMessage());
        }
    }

    private static void borrarCurso(Connection conexion) {
        System.out.println("Introduce el ID del curso que quieres borrar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "DELETE FROM Curso WHERE id_curso = ?";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, id);
            System.out.println("Cursos borrados: " + sentencia.executeUpdate());
        } catch (SQLException e) {
            System.err.println("No se pudo borrar el curso: " + e.getMessage());
        }
    }
}