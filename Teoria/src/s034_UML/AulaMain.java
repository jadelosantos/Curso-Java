package s034_UML;

public class AulaMain {
    public static void main(String[] args) {

        Academia academia = new Academia(
                1L,
                "Academia Java",
                "Calle Mayor 15, Madrid",
                "910123456",
                "info@academiajava.es"
        );

        Aula aula1 = new Aula(101L, "Aula de programación", 25, "Planta 1");
        Aula aula2 = new Aula(102L, "Aula de redes", 20, "Planta 2");
        Aula aula3 = new Aula(103L, "Aula multimedia", 30, "Planta baja");

        academia.agregarAula(aula1);
        academia.agregarAula(aula2);
        academia.agregarAula(aula3);

        System.out.println("Academia: " + academia.getNombre());
        System.out.println("Aulas:");
        for (Aula aula : academia.listarAulas()) {
            System.out.println(aula.obtenerInfo());
        }
    }
}
