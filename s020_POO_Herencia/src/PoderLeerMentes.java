public class PoderLeerMentes extends Hero {
    private int distancia;

    public PoderLeerMentes(String nombre, int distancia) {
        super(nombre);
        this.distancia = distancia;
    }

    @Override
    public void msg() {
        System.out.println(nombre + " puede leer mentes");
        System.out.println("Distancia: " + distancia + " metros");
    }
}
