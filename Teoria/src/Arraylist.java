import java.util.ArrayList;

public class Arraylist {
    private static ArrayList<String> nombres = new ArrayList<>();
    private static ArrayList<Integer> notas = new ArrayList<>();

    static void main() {
        nombres.add("Ana");
        nombres.add("Pepito");
        nombres.add("Juanito");
        notas.add(8);
        notas.add(4);
        notas.add(6);

        System.out.println("Primer nombre: " + nombres.get(0));
        System.out.println("Segundo nombre: " + nombres.get(1));
        System.out.println("Tercer nombre: " + nombres.get(2));

        System.out.println("Lista de nombres: " + nombres);

        nombres.add("Pedro");
        nombres.remove("Pedro");

        System.out.println("Cantidad de nombres: " + nombres.size());

        for(int i = 0;i< nombres.size();i++){
            System.out.println("Nombre: " + nombres.get(i));
            System.out.println("Nota: " + notas.get(i));
        }
    }

}
