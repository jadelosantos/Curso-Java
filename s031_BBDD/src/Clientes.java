public class Clientes {
    public String id_cliente = "id_cliente";
    public String nombre = "nombre";
    public String apellidos = "apellidos";
    public String telefono = "telefono";
    public String email = "email";
    public String ciudad = "ciudad";

    public Clientes() {
    }

    public Clientes(String id_cliente, String nombre, String apellidos,
                    String telefono, String email, String ciudad) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
    }
}
