public abstract class Vehiculo implements Alquiler {
    private String marca;
    private String modelo;
    private double precioDia;

    public Vehiculo(String marca, String modelo, double precioDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioDia = precioDia;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    @Override
    public double calcularAlquiler(int dias) {
        return precioDia * dias;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" Marca: ").append(marca).append("\n");
        sb.append(" Modelo: ").append(modelo).append('\n');
        sb.append(" Precio/Dia: ").append(precioDia + "€");
        return sb.toString();
    }
}
