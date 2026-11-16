import java.util.List;

public class BuscarLibros {
    public static void main(String[] args) {
        List<String> libros = List.of(
                "Java básico",
                "Python práctico",
                "Java avanzado",
                "Desarrollo web"
        );
        libros.stream()
                .filter(titulo -> titulo.contains("Java"))
                .forEach(System.out::println);
    }
}