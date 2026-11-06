public class Ejemplo_Array {


    static void main() {
        // Guardar 5 edades de alumnos
        int edad1 = 20;
        int edad2 = 25;
        int edad3 = 30;
        int edad4 = 35;
        int edad5 = 40;

        int result1 = (edad1 + edad2 + edad3 + edad4 + edad5) / 5;
        System.out.println("Edad Media: " + result1);

        //Modo Array
        String[] alumnos = {"Pablo","Gabriela","Rafa","Francisco","Fahd"};
        int[] edades = {20, 25, 30, 35, 40};

        int result2 = 0;
        for (int i = 0; i < edades.length; i++) {
            result2 += edades[i];
            System.out.println(alumnos[i] + " tiene " + edades[i] + " años");
        }
        System.out.println("Edad media: " + result2/5);

        //Array bidimensional
        int [][] notas ={
                {8,7,9,8,7},
                {6,8,7,7,6},
                {9,9,10,7,7},
                {9,9,10,7,7}
        };

        for(int i = 0;i<notas.length;i++){
            for(int j = 0;j<notas[i].length;j++){
                System.out.print(notas[i][j] + "\t");
            }
            System.out.println();
        }


    }
}
