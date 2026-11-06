package POO;

public class Ejercicio_5_Pizza {
    public enum tamanio{
        MEDIANA,
        FAMILIAR
    }

    public enum tipo{
        MARGARITA,
        CUATROQUESOS,
        FUNGHI
    }

    public enum estado{
        PEDIDA,
        SERVIDA
    }
    private tamanio tamanioPizza;
    private tipo tipoPizza;
    private estado estadoPizza;
    private int numPedido;
    private int totalPizzasPedidas;
    private int totalPizzasServidas;

    public Ejercicio_5_Pizza(tamanio tamanioPizza, tipo tipoPizza, estado estadoPizza, int numPedido) {
        this.tamanioPizza = tamanioPizza;
        this.tipoPizza = tipoPizza;
        this.estadoPizza = estadoPizza;
        this.numPedido = numPedido;
    }

    public tamanio getTamanioPizza() {
        return tamanioPizza;
    }

    public void setTamanioPizza(tamanio tamanioPizza) {
        this.tamanioPizza = tamanioPizza;
    }

    public tipo getTipoPizza() {
        return tipoPizza;
    }

    public void setTipoPizza(tipo tipoPizza) {
        this.tipoPizza = tipoPizza;
    }

    public estado getEstadoPizza() {
        return estadoPizza;
    }


    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public void setEstadoPizza(estado estadoPizza) {
        this.estadoPizza = estadoPizza;
    }

    public int getTotalPizzasPedidas() {
        return totalPizzasPedidas;
    }

    public void setTotalPizzasPedidas(int totalPizzasPedidas) {
        this.totalPizzasPedidas = totalPizzasPedidas;
    }

    public int getTotalPizzasServidas() {
        return totalPizzasServidas;
    }

    public void setTotalPizzasServidas(int totalPizzasServidas) {
        this.totalPizzasServidas = totalPizzasServidas;
    }

    @Override
    public String toString() {
        return "Info de pizza {" +
                "Tamaño de pizza:" + tamanioPizza +
                ", Tipo de pizza: " + tipoPizza +
                ", numero de pedido :"+ numPedido +
                '}';
    }
}
