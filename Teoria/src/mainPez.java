public class mainPez {
    private static String nombrePez = "Tiburon";
    private static double pesoPez = 50;
    private static int esperanzaVidaPez = 6;


    static void main() {
        Pez pez1 = new Pez(nombrePez,pesoPez,esperanzaVidaPez);
        pez1.moverAletas();
    }
}
