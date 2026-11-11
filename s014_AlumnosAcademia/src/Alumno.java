public class Alumno {
    private String nombre;
    private int nota;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota <= 10 ) {
            this.nota = nota;
        }
    }

    public void mostrarResultado(){
        System.out.println("Nombre: " + nombre);
        System.out.println(nota >= 5 ? "Nota: " + nota + " Ha aprobado" : "Nota: " + nota + " ha suspendido");
    }
}
