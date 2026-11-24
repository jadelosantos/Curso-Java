/*
 1. Ejercicio práctico de Java: Hilos (Threads) y
condicionales IF-ELSE
Te propongo un ejercicio de nivel inicial-intermedio para practicar programación multihilo en
Java (Thread) y estructuras condicionales (if, else if, else).
Enunciado: Sistema de control de temperatura📝
Una empresa necesita desarrollar un programa en Java que permita controlar la temperatura de una
máquina industrial utilizando dos hilos de ejecución.
1. Requisitos del programa
Debes crear una aplicación Java que cumpla las siguientes condiciones:
Hilo 1: Control de temperatura
• Debe llamarse HiloTemperatura.
• Simulará la lectura de temperatura de una máquina.
• Generará 5 temperaturas aleatorias entre 0 y 100 grados.
• Esperará 2 segundos entre cada lectura.
• Mostrará por pantalla cada temperatura obtenida.
Hilo 2: Sistema de alertas
• Debe llamarse HiloAlertas.
• Comprobará el estado de la temperatura.
• Utilizará estructuras if, else if y else para determinar el estado de la máquina.
2. Condiciones adicionales
1. Los dos hilos deben ejecutarse de forma independiente.
2. Cada hilo debe mostrar su nombre por pantalla.
3. Utiliza Thread.sleep() para controlar los tiempos de ejecución.
4. Utiliza Math.random() para generar temperaturas aleatorias.
5. Utiliza start() para iniciar los hilos.
6. Utiliza run() para definir el comportamiento de cada hilo.
Nota didáctica: Esta segunda versión sirve para practicar, pero todavía tiene un problema: los hilos
pueden leer la misma temperatura varias veces o consultar el valor inicial. Para sincronizar
correctamente la producción y el consumo de datos se puede utilizar wait() y notifyAll() o
una BlockingQueue
 */

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Temperatura {
    private int temperatura;

    private final Random random = new Random();

    public synchronized void setTemperatura() {
        this.temperatura = random.nextInt(0, 100);
    }

    public synchronized int getTemperatura() {
        return temperatura;
    }
}

class HiloAlertas extends Thread {

    private Temperatura temperatura;
    private int comprobaciones;
    private BlockingQueue<Integer> cola;

    public HiloAlertas(Temperatura temperatura, int comprobaciones, BlockingQueue<Integer> cola) {
        this.temperatura = temperatura;
        this.comprobaciones = comprobaciones;
        this.cola = cola;
    }


    @Override
    public void run() {
        try {
            for (int i = 0; i < comprobaciones; i++) {
            int valor = cola.take();

                System.out.println("Temperatura actual: " + valor + " ºC");
                Thread.sleep(1000);
                if (valor < 30) {
                    System.out.println("Temperatura baja");
                } else if (valor > 30 && valor <= 70) {
                    System.out.println("Temperatura normal");
                } else {
                    System.out.println("¡ALERTA! Temperatura elevada");
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

class HiloTemperatura extends Thread {

    private Temperatura temperatura;
    private int lecturas;
    private BlockingQueue<Integer> cola;

    public HiloTemperatura(Temperatura temperatura, int lecturas, BlockingQueue<Integer> cola) {
        this.temperatura = temperatura;
        this.lecturas = lecturas;
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < lecturas; i++) {
                temperatura.setTemperatura();
                int valor = temperatura.getTemperatura();
                cola.put(valor);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}


public class Ejercicio1 {
    static void main() throws InterruptedException {
        BlockingQueue<Integer> cola = new ArrayBlockingQueue<>(1);
        System.out.println("Iniciando sistema de control...");
        Temperatura temperatura = new Temperatura();
        HiloTemperatura hiloTemperatura = new HiloTemperatura(temperatura,5,cola);
        HiloAlertas hiloAlertas = new HiloAlertas(temperatura,5,cola);
        hiloTemperatura.start();
        hiloAlertas.start();
    }
}
