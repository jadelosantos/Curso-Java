/*4. Ejercicio Java: Hilos (Thread) y Arrays📝
Nivel: Principiante - Intermedio
Objetivo: Aprender a utilizar arrays (arreglos) junto con hilos de ejecución en Java.
Te propongo un ejercicio práctico para trabajar con dos hilos que accederán a un array de números
enteros.
1. Enunciado: Sistema de análisis de notas
Un profesor necesita desarrollar una aplicación Java que permita analizar las notas de 10 alumnos
utilizando dos hilos independientes.
HILO 1: Introducir y mostrar notas
Crea una clase llamada HiloNotas que herede de Thread.
Este hilo deberá:
1. Crear un array de 10 posiciones.
2. Introducir 10 notas aleatorias entre 0 y 10.
3. Guardar las notas dentro del array.
4. Mostrar todas las notas por pantalla.
5. Esperar 1 segundo entre cada nota utilizando Thread.sleep().
HILO 2: Analizar las notas
Crea una clase llamada HiloAnalisis que herede de Thread.
Este hilo deberá:
1. Recibir el array de notas del primer hilo.
2. Recorrer el array utilizando un bucle for.
3. Calcular la suma de todas las notas.
4. Calcular la media de las notas.
5. Identificar la nota más alta.
6. Identificar la nota más baja.
7. Mostrar los resultados por pantalla.
2. Condiciones del ejercicio
Debes utilizar obligatoriamente:
Elemento Utilización
Thread Crear los dos hilos.
run() Definir el comportamiento de cada hilo.
start() Iniciar los hilos.
sleep() Introducir pausas.
join() Esperar a que termine el primer hilo.
int[] Crear el array de notas.
for Recorrer el array.
Math.random() Generar notas aleatorias.
if-else Comparar las notas.
3. Ejemplo de resultado esperado
Iniciando sistema de análisis de notas...
HiloNotas: Introduciendo notas...
Alumno 1: 7
Alumno 2: 5
Alumno 3: 9
Alumno 4: 4
Alumno 5: 8
Alumno 6: 6
Alumno 7: 3
Alumno 8: 10
Alumno 9: 5
Alumno 10: 7
HiloAnalisis: Analizando notas...
Suma total: 64
Media: 6.4
Nota más alta: 10
Nota más baja: 3
Sistema finalizado.
Los valores son un ejemplo; las notas serán aleatorias.
Ejemplo de ejecución
Iniciando sistema de análisis de notas...
HiloNotas: Introduciendo notas...
Alumno 1: 7
Alumno 2: 5
Alumno 3: 9
Alumno 4: 4
Alumno 5: 8
Alumno 6: 6
Alumno 7: 3
Alumno 8: 10
Alumno 9: 5
Alumno 10: 7
HiloNotas: Notas generadas.
HiloAnalisis: Analizando notas...
========== RESULTADOS ==========
Suma total: 64
Media: 6.4
Nota más alta: 10
Nota más baja: 3
Alumnos aprobados: 8
Alumnos suspendidos: 2
================================
Sistema finalizado.*/

/*HILO 1: Introducir y mostrar notas
Crea una clase llamada HiloNotas que herede de Thread.
Este hilo deberá:
1. Crear un array de 10 posiciones.
2. Introducir 10 notas aleatorias entre 0 y 10.
3. Guardar las notas dentro del array.
4. Mostrar todas las notas por pantalla.
5. Esperar 1 segundo entre cada nota utilizando Thread.sleep().*/

import java.util.Random;

class GenerarNotas extends Thread {
    private Random random = new Random();
    private int[] notas = new int[10];

    @Override
    public void run() {
        System.out.println("Introduciendo notas... ");
        for (int i = 0; i < notas.length;i++){
            int nota = random.nextInt(0,11);
            notas[i] = nota;
        }

        try {
            for(int i = 1; i < notas.length;i++){
                System.out.println("Alumno " + i + ": " + notas[i]);
                Thread.sleep(1000);
            }
            System.out.println("Notas generadas.");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }
}

/*HILO 2: Analizar las notas
Crea una clase llamada HiloAnalisis que herede de Thread.
Este hilo deberá:
1. Recibir el array de notas del primer hilo.
2. Recorrer el array utilizando un bucle for.
3. Calcular la suma de todas las notas.
4. Calcular la media de las notas.
5. Identificar la nota más alta.
6. Identificar la nota más baja.
7. Mostrar los resultados por pantalla.*/
class CalcularNotas extends Thread {
    private int[] notas;
    private int sumaNotas;
    private int media;
    int notaAlta;
    int notaBaja;
    private int alumnosSuspendidos;
    private int alumnosAprobados;
    public CalcularNotas(int[] notas) {
        this.notas = notas;
    }


    @Override
    public void run() {
        for (int i = 0; i < notas.length; i++) {
            sumaNotas += notas[i];
        }

        media = sumaNotas / notas.length;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > notaAlta) {
                notaAlta = notas[i];
            }
            if (notas[i] < notaBaja) {
                notaBaja = notas[i];
            }
            if(notas[i] < 5){
                alumnosSuspendidos++;
            }else{
                alumnosAprobados++;
            }
        }

        try {
            for (int i = 1; i < notas.length; i++) {
                System.out.println("Nota " + i + " :" +  notas[i]);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("========== RESULTADOS ==========");
        System.out.println("Suma total: " + sumaNotas);
        System.out.println("Media: " + media);
        System.out.println("Nota más alta: " + notaAlta);
        System.out.println("Nota más baja: " + notaBaja);
        System.out.println("Alumnos aprobados: " + alumnosAprobados);
        System.out.println("Alumnos suspendidos: " + alumnosSuspendidos);
        System.out.println("================================");
        System.out.println("Sistema finalizado.");

    }
}

public class Ejercicio4 {
    static void main() throws InterruptedException {
        GenerarNotas generarNotas = new GenerarNotas();
        generarNotas.start();
        generarNotas.join();
        int[] notas = generarNotas.getNotas();
        CalcularNotas calcularNotas = new CalcularNotas(notas);
        calcularNotas.start();
        calcularNotas.join();
    }
}
