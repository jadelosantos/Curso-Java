package s034_UML;

public class Aula {
    private long idAula;
    private String nombre;
    private int capacidad;
    private String ubicacion;

    public Aula(long idAula, String nombre, int capacidad, String ubicacion) {
        this.idAula = idAula;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    public void actualizarCapacidad(int cap){
        System.out.println(this.capacidad > cap ? this.capacidad = cap : "El aula ha alcanzado la maxima capacidad");
    }


    public long getIdAula() {
        return idAula;
    }

    public void setIdAula(long idAula) {
        this.idAula = idAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String obtenerInfo() {
        final StringBuilder sb = new StringBuilder("Aula: \n");
        sb.append("idAula: ").append(idAula).append('\n');
        sb.append("nombre: ").append(nombre).append('\n');
        sb.append("capacidad: ").append(capacidad).append('\n');
        sb.append("ubicacion: ").append(ubicacion).append('\n');
        return sb.toString();
    }
}
