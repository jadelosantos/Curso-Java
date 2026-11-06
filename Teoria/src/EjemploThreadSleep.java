public class EjemploThreadSleep {
    static void main() {
        for(int i = 1;i<=21;i*=2){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.err.println("El hilo fue interrumpido");
            }
        }
    }
}
