public class Pez implements nadar {
    private String nombreCientifico;
    private double peso;
    private int esperanzaVida;

    public Pez(String nombreCientifico, double peso, int esperanzaVida) {
        this.nombreCientifico = nombreCientifico;
        this.peso = peso;
        this.esperanzaVida = esperanzaVida;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEsperanzaVida() {
        return esperanzaVida;
    }

    public void setEsperanzaVida(int esperanzaVida) {
        this.esperanzaVida = esperanzaVida;
    }

    @Override
    public void moverAletas() {
        System.out.println("Moviendo aletas...");
    }
}


interface nadar {
    void moverAletas();
}
