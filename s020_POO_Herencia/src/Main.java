public class Main {
    public static void main(String[] args) {
        // Crear personajes
        PoderVolar heroe1 = new PoderVolar("Superman", 1000);
        PoderDisparar heroe2 = new PoderDisparar("Ironman", 500);
        PoderNadar heroe3 = new PoderNadar("Aquaman", 200);
        PoderInvisible heroe4 = new PoderInvisible("Fantasma", 60);
        PoderLeerMentes heroe5 = new PoderLeerMentes("Profesor X", 100);

        // Mostrar información
        heroe1.msg();
        System.out.println("-----------");
        heroe2.msg();
        System.out.println("-----------");
        heroe3.msg();
        System.out.println("-----------");
        heroe4.msg();
        System.out.println("-----------");
        heroe5.msg();
    }
}
