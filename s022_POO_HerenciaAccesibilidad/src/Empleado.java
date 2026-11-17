public class Empleado {
    private String nombre;
    private String dni;
    protected double salario;
    public String nombreEmpresa;

    public Empleado(String nombre, String dni, double salario, String nombreEmpresa) {
        this.nombre = nombre;
        this.dni = dni;
        this.salario = salario;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append('\n');
        sb.append("DNI: ").append(dni).append('\n');
        sb.append("Salario: ").append(salario).append(" €").append('\n');
        sb.append("Nombre Empresa: ").append(nombreEmpresa).append('\n');
        return sb.toString();
    }
}
