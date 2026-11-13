public class Furgoneta extends Vehiculo implements Alquiler{
    public Furgoneta(String marca, String modelo, double precioDia) {
        super(marca, modelo, precioDia);
    }

    @Override
    public double calcularAlquiler(int dias) {
        return (getPrecioDia() + 25) * dias;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
