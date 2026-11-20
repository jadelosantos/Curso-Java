import java.util.Arrays;
import java.util.List;

public class s023_ProductoLambda {
    private String nombre;
    private double precio;

    public s023_ProductoLambda(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    static void main() {
        List<s023_ProductoLambda> productos = Arrays.asList(new s023_ProductoLambda("Auriculares", 50), new s023_ProductoLambda("Raton", 15), new s023_ProductoLambda("Teclado", 30), new s023_ProductoLambda("Monitor", 150), new s023_ProductoLambda("Alfombrilla", 10));
        productos.stream().forEach(System.out::println);
        productos.stream().filter(p -> p.getPrecio() > 20).forEach(p -> {
            double precioFinal = p.getPrecio() * 0.90;
            System.out.println(precioFinal);
        });

        List<Integer> numeros = Arrays.asList(30,50,60,30,80,90,35,85,95,105,40,70);
        long cantidad = numeros.stream().filter(n -> n > 75).count();
        System.out.println(cantidad);

    }
}
