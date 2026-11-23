class MiHilo1 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("Numero: " + i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.err.println("Hilo Interrumpido");
            }
        }
    }
}

public class s011_EjercicioMultihilos1{
    static void main() {
        MiHilo3 hilo = new MiHilo3();
        //hilo.start();
        System.out.println("hilo iniciado");
    }
}
