import java.sql.*;
import java.util.Scanner;

public class Ejercicio1 {
    private static String url = "jdbc:mysql://localhost:3307/BBDD_MYSQL";
    private static String usuario = "root";
    private static String contrasena = "";
    private static Scanner sc = new Scanner(System.in);
    private static boolean endprogram = false;
    static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
            Biblioteca biblioteca = new Biblioteca();
            do {
                System.out.println("Elige la operacion a realizar \n" +
                        "1.Leer\n" +
                        "2.Insertar\n" +
                        "3.Borrar\n" +
                        "4.Editar\n" +
                        "5.Consulta personalizada");
                int operacion = sc.nextInt();
                switch (operacion){
                    case 1:
                        leer(conexion);
                        System.out.println();
                        break;
                    case 2:
                        busquedaPersonalizada(conexion);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Introduce el titulo del libro:");
                        String titulo = sc.nextLine();
                        System.out.println("Introduce el autor del libro:");
                        String autor = sc.nextLine();
                        System.out.println("Introduce la editorial del libro:");
                        String editorial = sc.nextLine();
                        System.out.println("Introduce el año del libro:");
                        int anioLibro = sc.nextInt();
                        System.out.println("¿Esta disponible el libro? \n" +
                                "1.Si \n" +
                                "2.No \n");
                        int disponibilidad;

                        do {
                            System.out.println("¿Está disponible el libro?\n1. Sí\n2. No");
                            disponibilidad = sc.nextInt();

                            if (disponibilidad != 1 && disponibilidad != 2) {
                                System.out.println("Introduce 1 o 2.");
                            }
                        } while (disponibilidad != 1 && disponibilidad != 2);

                        boolean disponible = disponibilidad == 1;
                        Biblioteca libro = new Biblioteca(titulo,autor,editorial,String.valueOf(anioLibro),String.valueOf(disponible));
                        insertar(conexion,libro);
                    case 4:
                        System.out.println("Introduce el nuevo titulo del libro:");
                        String tituloNuevo = sc.nextLine();
                        System.out.println("Introduce el nuevo autor del libro:");
                        String autorNuevo = sc.nextLine();
                        System.out.println("Introduce la nuevo editorial del libro:");
                        String editorialNuevo = sc.nextLine();
                        System.out.println("Introduce el nuevo año del libro:");
                        int anioLibroNuevo = sc.nextInt();
                        System.out.println("¿Esta disponible el libro ahora? \n" +
                                "1.Si \n" +
                                "2.No \n");
                        int disponibilidadNuevo;

                        do {
                            System.out.println("¿Está disponible el libro?\n1. Sí\n2. No");
                            disponibilidadNuevo = sc.nextInt();

                            if (disponibilidadNuevo != 1 && disponibilidadNuevo != 2) {
                                System.out.println("Introduce 1 o 2.");
                            }
                        } while (disponibilidadNuevo != 1 && disponibilidadNuevo != 2);

                        boolean disponibleNuevo = disponibilidadNuevo == 1;
                        Biblioteca libroNuevo = new Biblioteca(tituloNuevo,autorNuevo,editorialNuevo,String.valueOf(anioLibroNuevo),String.valueOf(disponibleNuevo));
                        editar(conexion,libroNuevo);
                        System.out.println();
                    case 5:
                        borrar(conexion);
                    case 6:
                        endprogram = true;
                        break;
                    default:
                        System.err.println("Seleccione un numero del 1 al 5.");
                }
            } while (!endprogram);
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Ha habido un problema al conectarse a la base de datos " + e.getMessage());
        }
    }

    private static void leer(Connection conexion) {
        boolean hayResultados = false;
        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery("SELECT * FROM " + Biblioteca.class.getSimpleName())) {
            ResultSetMetaData columnas = resultado.getMetaData();

            while (resultado.next()) {
                hayResultados = true;
                for (int i = 1; i <= columnas.getColumnCount(); i++) {
                    System.out.print(columnas.getColumnLabel(i) + ": " + resultado.getString(i));
                    if (i < columnas.getColumnCount()) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

            if (!hayResultados) {
                System.out.println("La tabla " + Biblioteca.class + " no contiene registros.");
            }
        } catch (SQLException e) {
            System.err.println("Hubo un error al realizar la consulta: " + e.getMessage());
        }
    }

    private static void busquedaPersonalizada(Connection conexion) {
    boolean hayResultados = false;
    System.out.println("Introduce la consulta (asegurate de escribirla correctamente con los espacios correctos)");
    String consulta = sc.nextLine();
    try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consulta)) {
             ResultSetMetaData columnas = resultado.getMetaData();

            while (resultado.next()) {
                hayResultados = true;
                for (int i = 1; i <= columnas.getColumnCount(); i++) {
                    System.out.print(columnas.getColumnLabel(i) + ": " + resultado.getString(i));
                    if (i < columnas.getColumnCount()) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

            if (!hayResultados) {
                System.out.println("La tabla " + Biblioteca.class + " no contiene registros.");
            }
        } catch (SQLException e) {
            System.err.println("Hubo un error al realizar la consulta: " + e.getMessage());
        }
    }

    private static void insertar(Connection conexion, Biblioteca libro) {
        String sql = """
        INSERT INTO biblioteca (titulo, autor, editorial, anio, disponible)
        VALUES (?, ?, ?, ?, ?)
        """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, libro.titulo);
            sentencia.setString(2, libro.autor);
            sentencia.setString(3, libro.editorial);
            sentencia.setInt(4, Integer.parseInt(libro.anio));
            sentencia.setBoolean(5, Boolean.parseBoolean(libro.disponible));

            sentencia.executeUpdate();
            System.out.println("Libro insertado correctamente.");
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo insertar el libro: " + e.getMessage());
        }
    }

    private static void editar(Connection conexion, Biblioteca libro) {
        leer(conexion);
        System.out.println("introduce el id del libro a actualizar:");
        int idEditar = sc.nextInt();

        String sql = """
        UPDATE biblioteca
        SET titulo = ?, autor = ?, editorial = ?, anio = ?, disponible = ?
        WHERE id_libro = ?
        """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, libro.titulo);
            sentencia.setString(2, libro.autor);
            sentencia.setString(3, libro.editorial);
            sentencia.setInt(4, Integer.parseInt(libro.anio));
            sentencia.setBoolean(5, Boolean.parseBoolean(libro.disponible));
            sentencia.setInt(6,idEditar);
            sentencia.executeUpdate();
            System.out.println("Libro Actualizado correctamente.");
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo actualizar el libro: " + e.getMessage());
        }
    }

    private static void borrar(Connection conexion) {
        leer(conexion);
        System.out.println("Selecciona el numero del libro que quieres borrar");
        String titulo = sc.nextLine();
        String sql = """
        DELETE FROM biblioteca WHERE titulo = ?
        """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, titulo);

            int filasBorradas = sentencia.executeUpdate();
            System.out.println("Filas borradas: " + filasBorradas);
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo insertar el libro: " + e.getMessage());
        }
    }

}
