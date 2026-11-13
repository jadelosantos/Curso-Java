public class Vehiculo {
    protected String modelo;
    protected String color;

    public void arrancar(){
        System.out.println("Esta arrancando...");
    }


}

    class Moto extends Vehiculo{

        public void hacerCaballito(){
            System.out.println("Haciendo caballito...");
        }

    }
