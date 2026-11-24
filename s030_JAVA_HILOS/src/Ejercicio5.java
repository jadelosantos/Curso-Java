/*
5. Ejercicio Java: Hilos (Thread) y Scanner📝
Nivel: Principiante - Intermedio
Objetivo: Practicar la programación multihilo en Java utilizando Thread, entrada de datos
mediante Scanner y estructuras condicionales.
1. Enunciado: Sistema de registro de usuarios
Una empresa necesita desarrollar una aplicación Java para registrar usuarios y comprobar sus datos
mediante dos hilos independientes.
El programa solicitará información al usuario mediante teclado y realizará diferentes operaciones.
HILO 1: Registro de usuarios
Crea una clase llamada HiloRegistro que herede de Thread.
Este hilo deberá:
1. Solicitar al usuario su nombre mediante Scanner.
2. Solicitar su edad.
3. Solicitar su ciudad.
4. Mostrar los datos introducidos.
5. Esperar 2 segundos utilizando Thread.sleep().
6. Mostrar un mensaje indicando que el registro ha finalizado.
HILO 2: Comprobación de edad
Crea una clase llamada HiloComprobacion que herede de Thread.
Este hilo deberá:
1. Recibir la edad introducida por el usuario.
2. Comprobar si el usuario es mayor o menor de edad.
3. Utilizar if-else para realizar la comprobación.
4. Mostrar un mensaje indicando el resultado.
5. Esperar 3 segundos utilizando Thread.sleep().
6. Mostrar un mensaje indicando que la comprobación ha finalizado.
3. Ejemplo de ejecución
Iniciando sistema de registro...
Introduce tu nombre:
Carlos
Introduce tu edad:
25
Introduce tu ciudad:
Sevilla
HiloRegistro: Registrando usuario...
Nombre: Carlos
Edad: 25
Ciudad: Sevilla
HiloComprobacion: Comprobando edad...
El usuario es MAYOR DE EDAD.
HiloRegistro: Registro finalizado.
HiloComprobacion: Comprobación finalizada.
Sistema finalizado.
Ejemplo de ejecución
================================
SISTEMA DE REGISTRO DE USUARIOS
================================
Introduce tu nombre:
Carlos
Introduce tu edad:
25
Introduce tu ciudad:
Sevilla
Iniciando los hilos...
HiloRegistro: Registrando usuario...
Nombre: Carlos
Edad: 25
Ciudad: Sevilla
HiloComprobacion: Comprobando edad...
El usuario es MAYOR DE EDAD.
HiloRegistro: Registro finalizado.
HiloComprobacion: Comprobación finalizada.
================================
SISTEMA FINALIZADO
================================
*/

/*HILO 1: Registro de usuarios
Crea una clase llamada HiloRegistro que herede de Thread.
Este hilo deberá:
1. Solicitar al usuario su nombre mediante Scanner.
2. Solicitar su edad.
3. Solicitar su ciudad.
4. Mostrar los datos introducidos.
5. Esperar 2 segundos utilizando Thread.sleep().
6. Mostrar un mensaje indicando que el registro ha finalizado.*/

import java.util.Scanner;

class Registro extends Thread{
    private Scanner sc = new Scanner(System.in);
    private int edad;

    public int getEdad() {
        return edad;
    }

    @Override
    public void run() {
        try {
        System.out.println("================================");
        System.out.println("SISTEMA DE REGISTRO DE USUARIOS");
        System.out.println("================================");
        System.out.println("Introduce tu nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce tu edad:");
        edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce tu ciudad:");
        String ciudad = sc.nextLine();
        System.out.println("Registrando usuario...");
        Thread.sleep(2000);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Edad: "+ edad);
        System.out.println("Ciudad: "+ ciudad);
        Thread.sleep(2000);
        System.out.println("================================");
        System.out.println("SISTEMA DE REGISTRO FINALIZADO");
        System.out.println("================================");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

/*HILO 2: Comprobación de edad
Crea una clase llamada HiloComprobacion que herede de Thread.
Este hilo deberá:
1. Recibir la edad introducida por el usuario.
2. Comprobar si el usuario es mayor o menor de edad.
3. Utilizar if-else para realizar la comprobación.
4. Mostrar un mensaje indicando el resultado.
5. Esperar 3 segundos utilizando Thread.sleep().
6. Mostrar un mensaje indicando que la comprobación ha finalizado.*/

class Comprobacion extends Thread{
    private int edad;

    public Comprobacion(int edad) {
        this.edad = edad;
    }

    @Override
    public void run() {
        try {
            System.out.println("Comprobando edad...");
            Thread.sleep(2000);
            System.out.println(edad >= 18 ? "ES MAYOR DE EDAD": "ES MENOR DE EDAD");
            Thread.sleep(3000);
            System.out.println("Comprobacion finalizada.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

public class Ejercicio5 {
    static void main() throws InterruptedException {
        Registro registro = new Registro();
        registro.start();
        registro.join();
        Comprobacion comprobacion = new Comprobacion(registro.getEdad());
        comprobacion.start();
        comprobacion.join();
    }
}
