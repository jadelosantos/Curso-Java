package s034_UML;

import java.util.ArrayList;

public class Academia {
    private long idAcademia;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private ArrayList<Aula> aulas = new ArrayList<>();

    public Academia(long idAcademia, String nombre, String direccion, String telefono, String email) {
        this.idAcademia = idAcademia;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public void agregarAula(Aula aula){
        aulas.add(aula);
    }

    public void eliminarAula(Aula aula){
        aulas.remove(aula);
    }

    public void buscarAula(long idAula){
        System.out.println(aulas.stream().filter(aula -> aula.getIdAula() == idAula).findFirst());
    }

    public ArrayList<Aula> listarAulas(){
        return aulas;
    }

    public long getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(long idAcademia) {
        this.idAcademia = idAcademia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
