import java.util.List;

public class s005_Stream {

    static void main() {
        List<String> lenguajes = List.of("Java","Python","Javascript","C#");
        lenguajes.stream().forEach(System.out::println);
        lenguajes.stream().filter(libro -> libro.contains("Java")).forEach(System.out::println);
        lenguajes.stream().filter(libro -> libro.length() >= 5).forEach(System.out::println);

    }
}
