package POO;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_5_Pizza_Main {
    private static Scanner sc = new Scanner(System.in);
    private static Ejercicio_5_Pizza.tamanio tamanio;
    private static Ejercicio_5_Pizza.tipo tipo;
    private static ArrayList<Ejercicio_5_Pizza> totalPizzas = new ArrayList<>();

    static void main() {
        System.out.println("1.Mediana");
        System.out.println("2.Familiar");
        int opcionTamanio = sc.nextInt();
        System.out.println("1.Margarita");
        System.out.println("2.Cuatro quesos");
        System.out.println("3.Funghi");
        int opcionTipo = sc.nextInt();
        switch (opcionTamanio) {
            case 1:
                tamanio = Ejercicio_5_Pizza.tamanio.MEDIANA;
                break;
            case 2:
                tamanio = Ejercicio_5_Pizza.tamanio.FAMILIAR;
                break;
        }
        switch (opcionTipo) {
            case 1:
                tipo = Ejercicio_5_Pizza.tipo.MARGARITA;
                break;
            case 2:
                tipo = Ejercicio_5_Pizza.tipo.CUATROQUESOS;
                break;
            case 3:
                tipo = Ejercicio_5_Pizza.tipo.FUNGHI;
                break;
            
        }

    }

    private static void pedirPizza(Ejercicio_5_Pizza.tamanio tamanio, Ejercicio_5_Pizza.tipo tipo, int numPedido) {
        Ejercicio_5_Pizza pizza = new Ejercicio_5_Pizza(tamanio, tipo, Ejercicio_5_Pizza.estado.PEDIDA, numPedido);
        totalPizzas.add(pizza);
    }

    private static void servirPizza(int numPedido) {
        for (Ejercicio_5_Pizza pizza : totalPizzas) {
            if (pizza.getNumPedido() == numPedido) {
                pizza.setEstadoPizza(Ejercicio_5_Pizza.estado.SERVIDA);
                System.out.println(pizza.toString());
            }
        }
    }

    private static void mostrarTodasPizzas(){
        for(Ejercicio_5_Pizza pizza : totalPizzas){
            System.out.println("Pizza " + pizza.getTipoPizza());
        }
    }
}
