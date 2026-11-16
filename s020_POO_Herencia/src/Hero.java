public class Hero {
    // Atributo
    protected String nombre;

    // Constructor
    public Hero(String nombre) {
        this.nombre = nombre;
    }

    // Método
    public void msg() {
        System.out.println(nombre + " tiene superpoderes");
    }
}
