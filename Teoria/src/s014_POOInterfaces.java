public class s014_POOInterfaces {

    static void main() {
        Pajaro pajaro1 = new Pajaro();
    }
}

interface Volador {
    void volar();
}

class Pajaro implements Volador {
    @Override
    public void volar() {
        System.out.println("EL pajaro esta volando");
    }
}