
//Clases
class Estudiante{
    //Variables
    String nombre;
    int edad;

    //Procedimientos
    void saludo(){
        System.out.println("Hola soy un estudiante");
    }

    void mostrarDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }

    int calcularNotaMedia(int asignatura1,int asignatura2,int asignatura3){
       int suma = asignatura1+ asignatura2 + asignatura3;
       int notaMedia = suma/3;
       return notaMedia;
    }

    void deporte(String mensaje){
        System.out.println("Deporte: " + mensaje);
    }

    String mostrarDeporte(){
        return "karate";
    }
}


public class s009_POO {
    static void main() {
        Estudiante estudiante = new Estudiante();
        estudiante.saludo();

        estudiante.nombre = "Laura";
        estudiante.edad = 22;

        estudiante.mostrarDatos();
        Estudiante pepe = new Estudiante();
        pepe.nombre = "Pepe";
        pepe.edad = 32;
        pepe.saludo();
        pepe.mostrarDatos();
        int matematicas = 3;
        int historia = 9;
        int lengua = 7;
        System.out.println("La nota media de pepe es: " + pepe.calcularNotaMedia(matematicas,historia,lengua));
        pepe.deporte("Karate");
        System.out.println(pepe.mostrarDeporte());
    }
}
