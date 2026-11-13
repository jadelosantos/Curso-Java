public class s016_POOPolimorfismo {

    static void main() {

        Animal2 animal1 = new Perro();
        Animal2 animal2 = new Gato();

        animal1.hacerSonido();
        animal2.hacerSonido();


    }
}
    class Animal2{
        void hacerSonido(){
            System.out.println("Sonido de animal");
        }
    }

    class Perro extends Animal2{
        @Override
        void hacerSonido(){
            System.out.println("Guau");
        }
    }

    class Gato extends Animal2{
        @Override
        void hacerSonido(){
            System.out.println("Guau");
        }
    }
