import java.sql.*;
import java.util.Scanner;

public class Ejercicio7 {
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
                        1. Leer platos
                        2. Leer pedidos
                        3. Consulta personalizada
                        4. Insertar plato
                        5. Editar plato
                        6. Borrar plato
                        7. Insertar pedido
                        8. Editar pedido
                        9. Borrar pedido
                        10. Salir
                        """);

                int operacion = Integer.parseInt(sc.nextLine());

                switch (operacion) {
                    case 1 -> leer(conexion, "Platos");
                    case 2 -> leer(conexion, "Pedidos");
                    case 3 -> busquedaPersonalizada(conexion);
                    case 4 -> insertarPlato(conexion, pedirPlato());
                    case 5 -> editarPlato(conexion, pedirPlato());
                    case 6 -> borrarPlato(conexion);
                    case 7 -> insertarPedido(conexion, pedirPedido());
                    case 8 -> editarPedido(conexion, pedirPedido());
                    case 9 -> borrarPedido(conexion);
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

    private static Platos pedirPlato() {
        Platos plato = new Platos();

        System.out.print("Introduce el nombre del plato: ");
        plato.nombre = sc.nextLine();

        System.out.print("Introduce la categoría: ");
        plato.categoria = sc.nextLine();

        System.out.print("Introduce el precio: ");
        plato.precio = sc.nextLine();

        return plato;
    }

    private static Pedidos pedirPedido() {
        Pedidos pedido = new Pedidos();

        System.out.print("Introduce la fecha (AAAA-MM-DD): ");
        pedido.fecha = sc.nextLine();

        System.out.print("Introduce la cantidad: ");
        pedido.cantidad = sc.nextLine();

        System.out.print("Introduce el ID del plato: ");
        pedido.id_plato = sc.nextLine();

        return pedido;
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

    private static void insertarPlato(Connection conexion, Platos plato) {
        String sql = """
                INSERT INTO Platos (nombre, categoria, precio)
                VALUES (?, ?, ?)
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, plato.nombre);
            sentencia.setString(2, plato.categoria);
            sentencia.setDouble(3, Double.parseDouble(plato.precio));

            System.out.println("Platos insertados: " + sentencia.executeUpdate());
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo insertar el plato: " + e.getMessage());
        }
    }

    private static void editarPlato(Connection conexion, Platos plato) {
        System.out.println("Introduce el ID del plato que quieres editar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = """
                UPDATE Platos
                SET nombre = ?, categoria = ?, precio = ?
                WHERE id_plato = ?
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, plato.nombre);
            sentencia.setString(2, plato.categoria);
            sentencia.setDouble(3, Double.parseDouble(plato.precio));
            sentencia.setInt(4, id);

            System.out.println("Platos actualizados: " + sentencia.executeUpdate());
        } catch (SQLException | NumberFormatException e) {
            System.err.println("No se pudo editar el plato: " + e.getMessage());
        }
    }

    private static void borrarPlato(Connection conexion) {
        System.out.println("Introduce el ID del plato que quieres borrar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "DELETE FROM Platos WHERE id_plato = ?";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, id);
            System.out.println("Platos borrados: " + sentencia.executeUpdate());
        } catch (SQLException e) {
            System.err.println("No se pudo borrar el plato: " + e.getMessage());
        }
    }

    private static void insertarPedido(Connection conexion, Pedidos pedido) {
        String sql = """
                INSERT INTO Pedidos (fecha, cantidad, id_plato)
                VALUES (?, ?, ?)
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setDate(1, Date.valueOf(pedido.fecha));
            sentencia.setInt(2, Integer.parseInt(pedido.cantidad));
            sentencia.setInt(3, Integer.parseInt(pedido.id_plato));

            System.out.println("Pedidos insertados: " + sentencia.executeUpdate());
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("No se pudo insertar el pedido: " + e.getMessage());
        }
    }

    private static void editarPedido(Connection conexion, Pedidos pedido) {
        System.out.println("Introduce el ID del pedido que quieres editar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = """
                UPDATE Pedidos
                SET fecha = ?, cantidad = ?, id_plato = ?
                WHERE id_pedido = ?
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setDate(1, Date.valueOf(pedido.fecha));
            sentencia.setInt(2, Integer.parseInt(pedido.cantidad));
            sentencia.setInt(3, Integer.parseInt(pedido.id_plato));
            sentencia.setInt(4, id);

            System.out.println("Pedidos actualizados: " + sentencia.executeUpdate());
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("No se pudo editar el pedido: " + e.getMessage());
        }
    }

    private static void borrarPedido(Connection conexion) {
        System.out.println("Introduce el ID del pedido que quieres borrar:");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "DELETE FROM Pedidos WHERE id_pedido = ?";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, id);
            System.out.println("Pedidos borrados: " + sentencia.executeUpdate());
        } catch (SQLException e) {
            System.err.println("No se pudo borrar el pedido: " + e.getMessage());
        }
    }
}