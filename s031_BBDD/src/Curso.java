public class Curso {
    public String id_curso = "id_curso";
    public String nombre_curso = "nombre_curso";
    public String duracion = "duracion";
    public String precio = "precio";
    public String id_alumno = "id_alumno";

    public Curso() {
    }

    public Curso(String id_curso, String nombre_curso, String duracion,
                 String precio, String id_alumno) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.duracion = duracion;
        this.precio = precio;
        this.id_alumno = id_alumno;
    }
}
