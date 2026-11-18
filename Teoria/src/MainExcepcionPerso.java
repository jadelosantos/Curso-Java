public class MainExcepcionPerso {

    public static void main(String[] args) {

        Persona persona = new Persona();

        try {

            persona.establecerEdad(150);

            System.out.println(
                "Edad registrada: " + persona.getEdad()
            );

        } catch (EdadInvalidaException e) {

            System.out.println(e.getMessage());

        }

        System.out.println("El programa continúa ejecutándose.");
    }
}
