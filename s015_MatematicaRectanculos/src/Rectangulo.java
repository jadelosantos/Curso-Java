public class Rectangulo {
    double base;
    double altura;
    double lado1;
    double lado2;
    double lado3;
    double lado4;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.lado1 = 20;
        this.lado2 = 50;
        this.lado3 = 80;
        this.lado4 = 100;
    }

    public double calcularArea(){
        return base*altura;
    }

    public double calcularPerimetro(){
        return lado1+lado2+lado3+lado4;
    }

    public void mostrarDatos(double area,double perimetro){
        System.out.println("Area:" + area + " m2");
        System.out.println("Perimetro:" + perimetro + " m");
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
