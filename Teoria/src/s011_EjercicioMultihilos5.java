class HiloNumerico extends Thread {
    private int inicio;
    private int fin;

    public HiloNumerico(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }


    @Override
    public void run() {
        for (int i = inicio; i <= fin; i++) {
            System.out.println(Thread.currentThread().getName() + " " +  i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.err.println(e.getMessage());
            }
        }
    }
}



public class s011_EjercicioMultihilos5 {
    static void main() throws InterruptedException {
        HiloNumerico hiloNumerico = new HiloNumerico(1,6);
        HiloNumerico hiloNumero2 = new HiloNumerico(7,10);
        hiloNumerico.start();
        hiloNumerico.join();
        hiloNumero2.start();
        hiloNumero2.join();
    }
}
