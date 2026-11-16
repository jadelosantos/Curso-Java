import java.util.function.Predicate;

public class s002_LambdaPredicate {

    static void main() {
        // Crea un Predicate de Integer llamado esMayorDe10.
        // La lambda recibe "numero" y devuelve true si es mayor que 10; si no, devuelve false.
        Predicate<Integer> esMayorDe10 = numero -> numero > 10;

        // Evalúa el Predicate con el valor 15 e imprime el resultado (true) en la consola.
        System.out.println(esMayorDe10.test(15));
    }

}