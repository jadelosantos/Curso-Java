public class Biblioteca {
    public String id_libro = "id_libro";
    public String titulo = "titulo";
    public String autor = "autor";
    public String editorial = "editorial";
    public String anio = "anio";
    public String disponible = "disponible";

    public Biblioteca() {
    }

    public Biblioteca(String titulo, String autor,
                      String editorial, String anio, String disponible) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.disponible = disponible;
    }
}
