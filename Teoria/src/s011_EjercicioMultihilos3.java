class MiHilo3 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("Numero: " + i);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.err.println("Hilo Interrumpido");
            }
        }
    }
}

class HiloTareaSecundaria implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("Ejecutando tarea secundaria");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.err.println("Hilo Interrumpido");
            }
        }
    }
}



public class s011_EjercicioMultihilos3 {
    static void main() {
        MiHilo3 miHilo3 = new MiHilo3();
        Thread hilonew1 = new Thread(miHilo3);
        hilonew1.start();
        HiloTareaSecundaria miHiloSecundario = new HiloTareaSecundaria();
        Thread hiloTarea = new Thread(miHiloSecundario);
        hiloTarea.start();
    }
}
