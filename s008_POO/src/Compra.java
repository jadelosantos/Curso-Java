public class Compra {
    String cliente;
    String nombreProducto;
    double precio;
    final double descuento = 0.20;

    public void aplicarDescuento(){
        System.out.println("Precio final: " + precio * (1 - descuento) + "€");
    }

    @Override
    public String toString() {
        return "Cliente:'" + cliente + '\'' +
                ", Producto: '" + nombreProducto + '\'' +
                "precio:" + precio;
    }

}
