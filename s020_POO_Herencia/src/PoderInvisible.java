public class PoderInvisible extends Hero {
    private int duracion;

    public PoderInvisible(String nombre, int duracion) {
        super(nombre);
        this.duracion = duracion;
    }

    @Override
    public void msg() {
        System.out.println(nombre + " puede hacerse invisible");
        System.out.println("Duración: " + duracion + " segundos");
    }
}
