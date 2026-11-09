import java.util.Scanner;

class Coche{
    String marca;
    String modelo;
    int velocidad;

    void mostrarDatos(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad: " + velocidad + " km/h");
    }

    void acelerar(){
        velocidad += 10;
    }
    void frenar(){
        velocidad -= 10;
    }
}

public class s006_POO {
    private static Scanner sc = new Scanner(System.in);
    static void main() {
        Coche coche = new Coche();
        System.out.println("Introduce la marca del coche: ");
        coche.marca = sc.nextLine();
        System.out.println("Introduce el modelo del coche: ");
        coche.modelo = sc.nextLine();
        System.out.println("Introduce la velocidad del coche: ");
        coche.velocidad = sc.nextInt();
        coche.mostrarDatos();
        coche.acelerar();
        coche.mostrarDatos();
        coche.frenar();
        coche.mostrarDatos();
    }
}
