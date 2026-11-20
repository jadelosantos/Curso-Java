public class Pedido {
    private String nombre;
    private double importe;

    public Pedido(String nombre, double importe) {
        this.nombre = nombre;
        this.importe = importe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append('\n');
        sb.append("Importe: ").append(importe).append("€").append('\n');
        return sb.toString();
    }
}
