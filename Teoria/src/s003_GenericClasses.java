class Caja<T>{
    private T contenido;
    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
}



public class s003_GenericClasses {
    private static Caja<String> cajaTexto = new Caja<>("Hola, Java");
    private static Caja<Integer> cajaNumero = new Caja<>(100);

    static void main() {
        System.out.println(cajaTexto.getContenido());
        System.out.println(cajaNumero.getContenido());
    }
}
