public class PersonajesMarvel {

    // ATRIBUTOS
    String nombre;
    String identidad;
    String poder;
    int edad;

    // CONSTRUCTOR
    public PersonajesMarvel(String nombre, String identidad, String poder, int edad) {
        this.nombre = nombre;
        this.identidad = identidad;
        this.poder = poder;
        this.edad = edad;
    }

    // PROCEDIMIENTO 1: Mostrar datos
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Identidad: " + identidad);
        System.out.println("Poder: " + poder);
        System.out.println("Edad: " + edad);
    }

    // PROCEDIMIENTO 2: Presentarse
    public void presentarse() {
        System.out.println("Hola, soy " + nombre);
    }

    // PROCEDIMIENTO 3: Utilizar un poder
    public void utilizarPoder(String accion) {
        System.out.println(nombre + " utiliza su poder: " + accion);
    }

    // PROCEDIMIENTO 4: Atacar
    public void atacar(String enemigo) {
        System.out.println(nombre + " está atacando a " + enemigo);
    }
}