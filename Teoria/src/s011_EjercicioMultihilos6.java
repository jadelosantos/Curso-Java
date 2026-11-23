class Contador {
    private int contador;

    public synchronized void incrementar(){
        contador++;
    }

    public int getContador() {
        return contador;
    }
}

class HiloContador extends Thread{
    private Contador contador;

    public HiloContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
            System.out.println(Thread.currentThread().getName() + " " + contador.getContador());
        }
    }
}



public class s011_EjercicioMultihilos6 {
    static void main() throws InterruptedException {
        Contador contador = new Contador();
        HiloContador hiloContador1 = new HiloContador(contador);
        HiloContador hiloContador2 = new HiloContador(contador);
        hiloContador1.start();
        hiloContador1.join();
        hiloContador2.start();
        hiloContador2.join();
    }
}
