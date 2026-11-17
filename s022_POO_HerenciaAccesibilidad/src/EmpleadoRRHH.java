//CLASE HIJA DE EMPLEADO, QUE HEREDA LOS ATRIBUTOS Y METODOS DE LA CLASE PADRE EMPLEADO
public class EmpleadoRRHH extends Empleado {
	
	//DEFINO LOS ATRIBUTOS DE ESTA CLASE 
	private int contrataciones;
	
	//CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE LA CLASE PADRE Y DE ESTA CLASE
	public EmpleadoRRHH(String nombre, String dni, double salario, String nombreEmpresa, int contrataciones) {
		
		//SUPER CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE LA CLASE PADRE
		super(nombre, dni, salario, nombreEmpresa);
		
		this.contrataciones = contrataciones;
	}
	
	//METODOS GET Y SET DE LAS VARIABLES DE ESTA CLASE
	public int getContrataciones() {
		
		return contrataciones;
	}
	
	//METODO SET DE LA VARIABLE CONTRATACIONES
	public void setContrataciones(int contrataciones) {
		
		this.contrataciones = contrataciones;
	}
	
	//AHORA SOBRE ESCRIBIMOS EL METODO TO STRING PARA MOSTRAR LOS DATOS DEL EMPLEADO DE RRHH, AÑADIENDO LOS ATRIBUTOS DE ESTA CLASE
	
	@Override
	 public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ").append(getNombre()).append('\n');
		sb.append("DNI: ").append(getDni()).append('\n');
		sb.append("Salario: ").append(getSalario()).append('\n');
		sb.append("Nombre Empresa: ").append(getNombreEmpresa()).append('\n');
		sb.append("Contrataciones: ").append(contrataciones);
		return sb.toString();
	 }
	

}
