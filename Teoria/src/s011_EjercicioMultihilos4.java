class cuentaAtras extends Thread {
    @Override
    public void run() {
        for (int i = 5; i >= 0 ; i--) {
            System.out.println( i == 0 ? "Despegue!" : i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.err.println("Hilo Interrumpido");
            }
        }
    }
}


public class s011_EjercicioMultihilos4 {
    static void main() {
        cuentaAtras primerConteo = new cuentaAtras();
        primerConteo.start();
    }
}
