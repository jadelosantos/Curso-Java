public class s014_POO {
    private String nombre;
    private int edad;

    public s014_POO(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void saludar(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}
