public class MiRecurso implements AutoCloseable {

    public void ejecutar() {
        System.out.println("Ejecutando recurso...");
    }

    @Override
    public void close() {
        System.out.println("Cerrando recurso...");
    }
}
