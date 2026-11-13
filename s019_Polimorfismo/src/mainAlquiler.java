public class mainAlquiler {
    private Coche coche1;
    private Moto moto1;
    private Furgoneta furgoneta1;
    private static final int dias = 5;
    private static Vehiculo[] vehiculos = new Vehiculo[3];
    static void main() {
        Coche coche = new Coche("Toyota", "Corolla", 50.0);

        Moto moto = new Moto("Honda", "CB500F", 30.0);

        Furgoneta furgoneta = new Furgoneta("Mercedes", "Sprinter", 75.0);

        vehiculos[0] = coche;
        vehiculos[1] = moto;
        vehiculos[2] = furgoneta;

        for (Vehiculo vehiculo: vehiculos){
            System.out.println(vehiculo.getClass().getName());
            System.out.println(vehiculo.toString());
            System.out.println("Precio del alquiler: " + vehiculo.calcularAlquiler(dias) + "€");
        }


    }
}
