public class PoderDisparar extends Hero {
    private int potencia;

    public PoderDisparar(String nombre, int potencia) {
        super(nombre);
        this.potencia = potencia;
    }

    @Override
    public void msg() {
        System.out.println(nombre + " puede disparar");
        System.out.println("Potencia: " + potencia);
    }
}
