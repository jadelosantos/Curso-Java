import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;

public class historial_navegacion_web {
    private static String google = "google.com";
    private static String youtube = "youtube.com";
    private static String wikipedia = "wikipedia.org";
    private static String amazon = "amazon.es";
    private static Stack<String> historial = new Stack<>();
    private static DateTimeFormatter fecha = DateTimeFormatter.ISO_LOCAL_DATE;
    static void main() {
        historial.push(google);
        historial.push(youtube);
        historial.push(wikipedia);
        historial.push(amazon);

        if (!historial.isEmpty()) {
            for(String pagina: historial){
                System.out.println("Pagina visitada el dia: " + LocalDateTime.now().format(fecha) + " "  + pagina);
            }

            System.out.println("Ultima pagina visitada: " + historial.peek());
            System.out.println("<- Atras ");
            historial.pop();
            System.out.println(historial.peek());
        }


    }
}
