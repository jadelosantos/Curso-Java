public class s002_Libros {
    private String titulo;
    private String autor;
    private static boolean disponible;

    public s002_Libros(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        disponible = true;
    }


    public void prestar(){
        if(disponible){
            disponible = false;
            System.out.println("Prestamo realizado");
        }else{
            System.out.println("El libro no esta disponible");
        }
    }

    public void devolver(){
        disponible = true;
        System.out.println("Libro devuelto");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Libro\n");
        sb.append("titulo:").append(titulo).append('\n');
        sb.append("autor:'").append(autor).append('\n');
        return sb.toString();
    }

    static void main() {
        s002_Libros libro = new s002_Libros("Don quijote","Miguel de cervantes");
        libro.toString();
        libro.prestar();
        libro.toString();
        libro.devolver();
        libro.toString();
    }
}
