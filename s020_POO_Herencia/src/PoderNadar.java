public class PoderNadar extends Hero {
    private int velocidadNado;

    public PoderNadar(String nombre, int velocidadNado) {
        super(nombre);
        this.velocidadNado = velocidadNado;
    }

    @Override
    public void msg() {
        System.out.println(nombre + " puede nadar");
        System.out.println("Velocidad de nado: " + velocidadNado);
    }
}
