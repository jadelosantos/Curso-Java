/*
2. Ejercicio Java: Hilos (Thread) y Switch📝
(DayOfWeek)
Nivel: Principiante - Intermedio
Objetivo: Practicar la creación de hilos en Java y utilizar la estructura switch junto con la clase
DayOfWeek de Java Time.
1. Enunciado: Sistema de información semanal
Una empresa quiere desarrollar una aplicación Java que permita consultar los días de la semana y
mostrar las actividades programadas para cada día.
El programa deberá utilizar dos hilos independientes para realizar diferentes tareas.
Hilo 1: Consulta del día de la semana
Crea una clase llamada HiloDiaSemana que herede de Thread.
Este hilo deberá:
1. Obtener el día actual utilizando LocalDate.
2. Utilizar DayOfWeek para identificar el día de la semana.
3. Mostrar por pantalla el día actual.
4. Esperar 2 segundos entre cada consulta.
5. Realizar un total de 5 consultas.
Hilo 2: Actividades semanales
Crea una clase llamada HiloActividades que herede de Thread.
Este hilo deberá:
1. Obtener el día de la semana.
2. Utilizar una estructura switch para determinar la actividad correspondiente.
3. Mostrar por pantalla la actividad programada.
4. Esperar 3 segundos entre cada ejecución.
5. Realizar un total de 5 ejecuciones.
2. Condiciones del switch
Utiliza DayOfWeek para establecer las siguientes actividades:
Día Actividad
MONDAY Estudiar Java
TUESDAY Practicar programación
WEDNESDAY Realizar ejercicios
THURSDAY Estudiar bases de datos
FRIDAY Desarrollar un proyecto
SATURDAY Repasar contenidos
SUNDAY Día de descanso
Si el día no coincide con ninguno de los anteriores, muestra:
Día no válido.
3. Clase principal Main
Crea una clase Main que:
1. Muestre el mensaje «Iniciando aplicación».
2. Cree los dos objetos Thread.
3. Inicie ambos hilos utilizando start().
4. Utilice join() para esperar a que terminen.
5. Muestre «Aplicación finalizada».
4. Ejemplo de salida esperada
Iniciando aplicación...
HiloDiaSemana: Hoy es MONDAY
HiloActividades: Actividad de hoy:
Estudiar Java
HiloDiaSemana: Hoy es MONDAY
HiloActividades: Actividad de hoy:
Estudiar Java
HiloDiaSemana: Hoy es MONDAY
HiloDiaSemana: Hoy es MONDAY
HiloActividades: Actividad de hoy:
Estudiar Java
HiloDiaSemana: Hoy es MONDAY
Aplicación finalizada.
Nota: El orden de los mensajes puede cambiar porque los hilos se ejecutan de forma concurrente.

*/


import java.time.DayOfWeek;
import java.time.LocalDateTime;

/*Este hilo deberá:
1. Obtener el día de la semana.
2. Utilizar una estructura switch para determinar la actividad correspondiente.
3. Mostrar por pantalla la actividad programada.
4. Esperar 3 segundos entre cada ejecución.
5. Realizar un total de 5 ejecuciones.
2. Condiciones del switch
Utiliza DayOfWeek para establecer las siguientes actividades:
Día Actividad
MONDAY Estudiar Java
TUESDAY Practicar programación
WEDNESDAY Realizar ejercicios
THURSDAY Estudiar bases de datos
FRIDAY Desarrollar un proyecto
SATURDAY Repasar contenidos
SUNDAY Día de descanso
Si el día no coincide con ninguno de los anteriores, muestra:
Día no válido.*/
class ConsultarDia extends Thread{
    @Override
    public void run() {
        DayOfWeek fecha = LocalDateTime.now().getDayOfWeek();
        try {
            for (int i = 0; i < 5; i++) {
                switch (fecha){
                    case MONDAY:
                        System.out.println("Hoy es: Lunes");
                        Thread.sleep(1000);
                        System.out.println("Estudiar Java");
                        break;
                    case TUESDAY:
                        System.out.println("Hoy es: Martes");
                        Thread.sleep(1000);
                        System.out.println("Practicar programacion");
                        break;
                    case WEDNESDAY:
                        System.out.println("Hoy es: Miércoles");
                        Thread.sleep(1000);
                        System.out.println("Realizar ejercicios");
                        break;
                    case THURSDAY:
                        System.out.println("Hoy es: Jueves");
                        Thread.sleep(1000);
                        System.out.println("Estudiar Bases de datos");
                        break;
                    case FRIDAY:
                        System.out.println("Hoy es: Viernes");
                        Thread.sleep(1000);
                        System.out.println("Desarrollar un proyecto");
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}


public class Ejercicio2 {

    static void main() {
        ConsultarDia consultarDia = new ConsultarDia();
        consultarDia.start();
    }
}
