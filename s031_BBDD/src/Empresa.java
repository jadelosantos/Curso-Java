public class Empresa {
    public String id_empleado = "id_empleado";
    public String nombre = "nombre";
    public String departamento = "departamento";
    public String salario = "salario";
    public String edad = "edad";
    public String ciudad = "ciudad";

    public Empresa() {
    }

    public Empresa(String id_empleado, String nombre, String departamento,
                   String salario, String edad, String ciudad) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.edad = edad;
        this.ciudad = ciudad;
    }
}
