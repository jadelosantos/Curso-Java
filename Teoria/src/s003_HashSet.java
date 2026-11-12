import java.util.HashSet;
import java.util.Iterator;

public class s003_HashSet {
    private static HashSet<String> frutas = new HashSet<>();
    private static HashSet<Integer> cantFrutas = new HashSet<>();

    static void main() {
        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Naranja");
        frutas.add("Kiwi");

        System.out.println("¿Contiene Pera? " + frutas.contains("Pera"));

        for(String fruta: frutas){
            System.out.println("Fruta: " + fruta);
        }

        Iterator<Integer> it = cantFrutas.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }



    }
}
