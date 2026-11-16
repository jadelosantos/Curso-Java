public class PoderVolar extends Hero {
    private int velocidadVuelo;

    public PoderVolar(String nombre, int velocidadVuelo) {
        super(nombre);
        this.velocidadVuelo = velocidadVuelo;
    }

    @Override
    public void msg() {
        System.out.println(nombre + " puede volar");
        System.out.println("Velocidad: " + velocidadVuelo + " km/h");
    }
}
