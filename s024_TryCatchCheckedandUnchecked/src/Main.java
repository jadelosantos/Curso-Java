public class Main {

    public static void main(String[] args) {

        try (MiRecurso recurso = new MiRecurso()) {
            recurso.ejecutar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
