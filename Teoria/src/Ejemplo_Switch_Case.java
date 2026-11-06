public class Ejemplo_Switch_Case {
    static void main() {
        int notaAlumno = 10;
        switch (notaAlumno){
            case 1:
                System.out.println("Muy deficiente");
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("Deficiente");
                break;
            case 5:
                System.out.println("Suficiente");
                break;
            case 6,7,8,9:
                System.out.println("Notable");
                break;
            default:
                System.out.println("Sobresaliente");
                break;
        }
    }
}
