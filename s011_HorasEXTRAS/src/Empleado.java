public class Empleado {
    String nombreEmpleado;
    int horasExtras;
    double precioHora;

    public Empleado(String nombreEmpleado, int horasExtras, double precioHora) {
        this.nombreEmpleado = nombreEmpleado;
        this.horasExtras = horasExtras;
        this.precioHora = precioHora;
    }

    public void plusHoras(){
        if(horasExtras > 20){
            horasExtras += 10;
            System.out.println("Plus aplicado");
        }
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public void mostrarDatos(){
        System.out.println("Empleado:" + nombreEmpleado);
        System.out.println("Horas Extras:" + horasExtras);
        System.out.println("Precio Hora:" + precioHora);
    }
}
