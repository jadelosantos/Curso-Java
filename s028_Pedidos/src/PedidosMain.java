import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidosMain {

    static void main() {
        List<Pedido> pedidos = new ArrayList<>();
        AtomicInteger num = new AtomicInteger();
        pedidos.add(new Pedido("Ana García", 75.50));
        pedidos.add(new Pedido("Luis Martínez", 120.00));
        pedidos.add(new Pedido("Marta López", 250.75));
        pedidos.add(new Pedido("Carlos Sánchez", 99.99));
        pedidos.add(new Pedido("Elena Fernández", 145.30));
        pedidos.add(new Pedido("Javier Ruiz", 50.00));

        //Ejercicio 1
        pedidos.stream().forEach(pedido -> {
            System.out.println("Pedido: " + num.incrementAndGet());
            System.out.println(pedido.toString());

        });
        //Ejercicio 2
        pedidos.stream().filter(p -> p.getImporte() > 100).forEach(pedido -> {
            System.out.println("Pedido: " + num.incrementAndGet());
            System.out.println(pedido.toString());

        });
        //Ejercicio 3 y 4
        pedidos.stream().filter(p -> p.getImporte() > 100).forEach(pedido -> {
            pedido.setImporte(pedido.getImporte() * 0.15);
            System.out.println("Pedido: " + num.incrementAndGet());
            System.out.println(pedido.toString());
        });
        //Ejercicio 5
        System.out.println("Cantidad de pedidos que superan los 100€: " + pedidos.stream()
                .filter(p -> p.getImporte() > 100)
                .count());
    }
}
