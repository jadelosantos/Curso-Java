class MiHilo2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("Numero: " + i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.err.println("Hilo Interrumpido");
            }
        }
    }
}

class Hiloletras extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("Numero: " + i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.err.println("Hilo Interrumpido");
            }
        }
    }
}



public class s011_EjercicioMultihilos2{
    static void main() {
        MiHilo3 hilo2 = new MiHilo3();
        //hilo2.start();
        HiloTareaSecundaria hiloTareaSecundaria = new HiloTareaSecundaria();
       // hiloTareaSecundaria.start();
        System.out.println("hilo iniciado");
    }
}
