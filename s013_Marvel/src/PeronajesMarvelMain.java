public class PeronajesMarvelMain {

    public static void main(String[] args) {

        // CREAR OBJETO IRON MAN
        PersonajesMarvel ironman = new PersonajesMarvel(
                "Iron Man",
                "Tony Stark",
                "Tecnología y armadura",
                48
        );

        // CREAR OBJETO SPIDERMAN
        PersonajesMarvel spiderman = new PersonajesMarvel(
                "Spider-Man",
                "Peter Parker",
                "Telarañas y sentido arácnido",
                18
        );

        // CREAR OBJETO HULK
        PersonajesMarvel hulk = new PersonajesMarvel(
                "Hulk",
                "Bruce Banner",
                "Superfuerza",
                45
        );

        // CREAR OBJETO THOR
        PersonajesMarvel thor = new PersonajesMarvel(
                "Thor",
                "Thor Odinson",
                "Control del rayo",
                1500
        );

        // MOSTRAR IRON MAN
        System.out.println("====== IRON MAN ======");

        ironman.mostrarDatos();
        ironman.presentarse();
        ironman.utilizarPoder("Armadura Mark");
        ironman.atacar("Thanos");

        // MOSTRAR SPIDERMAN
        System.out.println("\n====== SPIDER-MAN ======");

        spiderman.mostrarDatos();
        spiderman.presentarse();
        spiderman.utilizarPoder("Lanzar telarañas");
        spiderman.atacar("Duende Verde");

        // MOSTRAR HULK
        System.out.println("\n====== HULK ======");

        hulk.mostrarDatos();
        hulk.presentarse();
        hulk.utilizarPoder("Superfuerza");
        hulk.atacar("Abominación");

        // MOSTRAR THOR
        System.out.println("\n====== THOR ======");

        thor.mostrarDatos();
        thor.presentarse();
        thor.utilizarPoder("Lanzar rayos");
        thor.atacar("Loki");

    }
}