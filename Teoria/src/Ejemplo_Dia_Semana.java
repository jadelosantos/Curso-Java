import java.time.LocalDateTime;

public class Ejemplo_Dia_Semana {
    private static LocalDateTime fecha = LocalDateTime.now();
    static void main() {
        String dia = fecha.getDayOfWeek().toString();
        switch (dia){
            case "MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY":
                System.out.println("Dia laborable");
                break;
            default:
                System.out.println("No laborable");
        }
    }
}

