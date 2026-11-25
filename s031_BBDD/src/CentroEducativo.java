public class CentroEducativo {
    public String id_alumno = "id_alumno";
    public String nombre = "nombre";
    public String apellidos = "apellidos";
    public String edad = "edad";
    public String curso = "curso";
    public String nota = "nota";

    public CentroEducativo() {
    }

    public CentroEducativo(String id_alumno, String nombre, String apellidos,
                           String edad, String curso, String nota) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.curso = curso;
        this.nota = nota;
    }
}
