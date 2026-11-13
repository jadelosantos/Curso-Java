public class Coche extends Vehiculo implements Alquiler{
    public Coche(String marca, String modelo, double precioDia) {
        super(marca, modelo, precioDia);
    }

    @Override
    public double calcularAlquiler(int dias) {
        double suplemento = getPrecioDia() + 15;
        return suplemento * dias;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
