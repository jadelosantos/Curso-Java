import java.sql.*;
import java.util.Scanner;

public class Ejercicio2 {
    private static String url = "jdbc:mysql://localhost:3307/BBDD_MYSQL";
    private static String usuario = "root";
    private static String contrasena = "";
    private static Scanner sc = new Scanner(System.in);
    private static boolean endprogram = false;
    static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
            do {
                System.out.println("Elige la operacion a realizar \n" +
                        "1.Leer\n" +
                        "2.Consulta personalizada\n" +
                        "3.Insertar\n" +
                        "4.Editar\n" +
                        "5.Borrar");
                int operacion = sc.nextInt();
                sc.nextLine();
                switch (operacion){
                    case 1:
                        System.out.println();
                        leer(conexion);
                        break;
                    case 2:
                        System.out.println();
                        busquedaPersonalizada(conexion);
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Introduce el nombre del producto:");
                        String nombre = sc.nextLine();
                        System.out.println("Introduce la categoria del producto:");
                        String categoria = sc.nextLine();
                        System.out.println("Introduce el precio del producto:");
                        double precio = sc.nextDouble();
                        System.out.println("Introduce el Stock del producto:");
                        int stock = sc.nextInt();

                        Tienda producto = new Tienda(nombre,categoria,String.valueOf(precio),String.valueOf(stock));
                        insertar(conexion,producto);
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("Introduce el Nuevo nombre del producto:");
                        String nombreNuevo = sc.nextLine();
                        System.out.println("Introduce la categoria del producto:");
                        String categoriaNuevo = sc.nextLine();
                        System.out.println("Introduce el precio del producto:");
                        double precioNuevo = sc.nextDouble();
                        System.out.println("Introduce el Stock del producto:");
                        int stockNuevo = sc.nextInt();

                        Tienda productoNuevo = new Tienda(nombreNuevo,categoriaNuevo,String.valueOf(precioNuevo),String.valueOf(stockNuevo));
                        editar(conexion,productoNuevo);
                        break;
                    case 5:
                        borrar(conexion);
                        break;
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
             ResultSet resultado = sentencia.executeQuery("SELECT * FROM " + Tienda.class.getSimpleName())) {
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
                System.out.println("La tabla " + Tienda.class + " no contiene registros.");
            }
            System.out.println();
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
            System.out.println();
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
                System.out.println("La tabla " + Tienda.class + " no contiene registros.");
            }
        System.out.println();
        } catch (SQLException e) {
            System.err.println("Hubo un error al realizar la consulta: " + e.getMessage());
        }
    }

    private static void insertar(Connection conexion, Tienda producto) {
        String sql = """
        INSERT INTO Tienda (nombre, categoria, precio, stock)
        VALUES (?, ?, ?, ?)
        """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, producto.nombre);
            sentencia.setString(2, producto.categoria);
            sentencia.setDouble(3, Double.parseDouble(producto.precio));
            sentencia.setInt(4, Integer.parseInt(producto.stock));
            sentencia.executeUpdate();
            System.out.println("Producto insertado correctamente.");
            System.out.println();
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo insertar el producto: " + e.getMessage());
        }
    }

    private static void editar(Connection conexion, Tienda producto) {
        leer(conexion);
        System.out.println("introduce el id del libro a actualizar:");
        int idEditar = sc.nextInt();

        String sql = """
        UPDATE tienda
        SET nombre = ?, categoria = ?, precio = ?, stock = ?
        WHERE id_producto = ?
        """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, producto.nombre);
            sentencia.setString(2, producto.categoria);
            sentencia.setDouble(3, Double.parseDouble(producto.precio));
            sentencia.setInt(4, Integer.parseInt(producto.stock));
            sentencia.setInt(6,idEditar);
            sentencia.executeUpdate();
            System.out.println("Producto Actualizado correctamente.");
            System.out.println();
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo actualizar el producto: " + e.getMessage());
        }
    }

    private static void borrar(Connection conexion) {
        leer(conexion);
        System.out.println("Selecciona el nombre del producto que quieres borrar");
        String nombre = sc.nextLine();
        String sql = """
        DELETE FROM tienda WHERE nombre = ?
        """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, nombre);

            int filasBorradas = sentencia.executeUpdate();
            System.out.println("Filas borradas: " + filasBorradas);
            System.out.println();
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo insertar el libro: " + e.getMessage());
        }
    }

}
