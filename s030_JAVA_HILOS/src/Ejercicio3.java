/*3. Ejercicio Java: Hilos (Thread) y bucle📝
DO-WHILE
Nivel: Principiante - Intermedio
Objetivo: Practicar la programación multihilo en Java utilizando Thread y estructuras repetitivas
do-while.
1. Enunciado: Sistema de control de acceso
Una empresa necesita desarrollar un programa Java que simule un sistema de control de acceso a
sus instalaciones.
El programa tendrá dos hilos independientes que realizarán diferentes tareas.
HILO 1: Control de intentos de acceso
Crea una clase llamada HiloAcceso que herede de Thread.
Este hilo deberá:
1. Simular intentos de acceso a una instalación.
2. Generar números aleatorios entre 1 y 10.
3. Mostrar por pantalla el número de intento.
4. Utilizar un bucle do-while para repetir los intentos.
5. Realizar un máximo de 5 intentos.
6. Esperar 2 segundos entre cada intento utilizando Thread.sleep().
HILO 2: Sistema de vigilancia
Crea una clase llamada HiloVigilancia que herede de Thread.
Este hilo deberá:
1. Mostrar un mensaje indicando que el sistema de vigilancia está activo.
2. Utilizar un bucle do-while.
3. Mostrar un mensaje de vigilancia en cada repetición.
4. Realizar 5 comprobaciones.
5. Esperar 3 segundos entre cada comprobación.
6. Mostrar un mensaje indicando que la vigilancia ha finalizado.
2. Condiciones adicionales
El programa debe cumplir los siguientes requisitos:
• Crear dos clases que hereden de Thread.
• Sobrescribir el método run().
• Utilizar start() para iniciar los hilos.
• Utilizar sleep() para controlar los tiempos.
• Utilizar join() para esperar a que terminen los dos hilos.
• Utilizar obligatoriamente el bucle do-while.
• Mostrar mensajes identificando cada hilo.
3. Ejemplo de salida esperada
Iniciando sistema de control de acceso...
HiloAcceso: Intento número 1
HiloVigilancia: Sistema de vigilancia activo.
HiloAcceso: Intento número 2
HiloVigilancia: Comprobación de seguridad 1
HiloAcceso: Intento número 3
HiloVigilancia: Comprobación de seguridad 2
HiloAcceso: Intento número 4
HiloVigilancia: Comprobación de seguridad 3
HiloAcceso: Intento número 5
HiloVigilancia: Comprobación de seguridad 4
HiloVigilancia: Comprobación de seguridad 5
HiloAcceso: Finalizados los intentos.
HiloVigilancia: Vigilancia finalizada.
Sistema de control finalizado.*/

/*HILO 1: Control de intentos de acceso
Crea una clase llamada HiloAcceso que herede de Thread.
Este hilo deberá:
1. Simular intentos de acceso a una instalación.
2. Generar números aleatorios entre 1 y 10.
3. Mostrar por pantalla el número de intento.
4. Utilizar un bucle do-while para repetir los intentos.
5. Realizar un máximo de 5 intentos.
6. Esperar 2 segundos entre cada intento utilizando Thread.sleep().*/

import java.util.Random;

class ControlIntentos extends Thread {
    @Override
    public void run() {
        try {
            int contadorIntentos = 0;
            Random random = new Random();
            do {
                int intento = random.nextInt(1, 10);
                System.out.println("Intento numero: " +  intento);
                contadorIntentos++;
                Thread.sleep(2000);
            } while (contadorIntentos < 5);
            System.out.println("Intentos Finalizados.");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

/*HILO 2: Sistema de vigilancia
Crea una clase llamada HiloVigilancia que herede de Thread.
Este hilo deberá:
1. Mostrar un mensaje indicando que el sistema de vigilancia está activo.
2. Utilizar un bucle do-while.
3. Mostrar un mensaje de vigilancia en cada repetición.
4. Realizar 5 comprobaciones.
5. Esperar 3 segundos entre cada comprobación.
6. Mostrar un mensaje indicando que la vigilancia ha finalizado.*/

class ControlAcceso extends Thread {
    @Override
    public void run() {
        try {
            int contadorComprobaciones = 1;
            Random random = new Random();
            System.out.println("Sistema de vigilancia activo");
            do {
                int intento = random.nextInt(1, 10);
                System.out.println("Comprobacion de seguridad: " +  intento);
                contadorComprobaciones++;
                Thread.sleep(2000);
            } while (contadorComprobaciones < 5);
            System.out.println("Vigilancia finalizada.");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

public class Ejercicio3 {
    static void main() throws InterruptedException {
        ControlIntentos controlIntentos = new ControlIntentos();
        ControlAcceso controlAcceso = new ControlAcceso();
        controlIntentos.start();
        controlAcceso.start();
        controlIntentos.join();
       controlAcceso.join();
    }
}
