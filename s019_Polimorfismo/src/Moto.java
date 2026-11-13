public class Moto extends Vehiculo implements Alquiler{
    public Moto(String marca, String modelo, double precioDia) {
        super(marca, modelo, precioDia);
    }

    @Override
    public double calcularAlquiler(int dias) {
        double descuento = 0.10;
        double sinDescuento = getPrecioDia() * dias;
        return sinDescuento * descuento;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
