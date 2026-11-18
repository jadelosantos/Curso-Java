package s028_ExcepcionesPersonalizadas;

public class Persona {

    private int edad;

    public void establecerEdad(int edad) throws EdadInvalidaException {

        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException(
                "ERROR: La edad debe estar entre 0 y 120 años."
            );
        }

        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
}
