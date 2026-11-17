//CLASE HIJA DE EMPLEADO, QUE HEREDA LOS ATRIBUTOS Y METODOS DE LA CLASE PADRE EMPLEADO
public class EmpleadoInformatica extends Empleado {
	
	//DEFINICION DE LOS ATRIBUTOS DE ESTA CLASE 
	private String especialidad; //ESTA VARIABLE VA DECIR EN QUE SE ESPCIALIZA EL EMPLEADO, DESARROLLADOR, ANALISTA, ETC
	private String lenguajeProgramacion; //ESTA VARIABLE VA DECIR QUE LENGUAJE DE PROGRAMACION DOMINA EL EMPLEADO, JAVA, C++, PYTHON, ETC
	
	//CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE LA CLASE PADRE Y DE ESTA CLASE 
	public EmpleadoInformatica(String nombre, String dni, double salario, String nombreEmpresa, String especialidad, String lenguajeProgramacion) {
		
		//SUPER CONSTRUCTOIR QUE INICIALIZA LAS VARIABLES DE LA CLASE PADRE
		super(nombre, dni, salario, nombreEmpresa);
		
		//INICIALIZACION DE LAS VARIABLES DE ESTA CLASE
		this.especialidad = especialidad;
		this.lenguajeProgramacion = lenguajeProgramacion;
		
	}
	
	//METODOS GET Y SET DE LAS VARIABLES DE ESTA CLASE
	
	//METODO GET DE LA VARIABLE LENGUAJE DE PROGRAMACION
	public String getEspcialidad() {
		
		return especialidad;
	}
	
	//METODO SET DE LA VARIABLE ESPECIALIDAD
	public void setEspecialidad(String especialidad) {
		
		this.especialidad = especialidad;
	}
	
	//METODO GET DE LA VARIABLE LENGUAJE DE PROGRAMACION
	public String getLenguajeProgramacion() {
		
		return lenguajeProgramacion;
	}
	
	//METODO SET DE LA VARIABLE LENGUAJE DE PROGRAMACION
	public void setLenguajeProgramacion(String lenguajeProgramacion) {
		
		this.lenguajeProgramacion = lenguajeProgramacion;
	}
	
	//AHORA SOBRE ESCRIBIMOS EL METODO TO STRING PARA MOSTRAR LOS DATOS DEL EMPLEADO DE INFORMATICA, AÑADIENDO LOS ATRIBUTOS DE ESTA CLASE
	
	@Override
	 public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ").append(getNombre()).append('\n');
		sb.append("DNI: ").append(getDni()).append('\n');
		sb.append("Salario: ").append(getSalario()).append('\n');
		sb.append("Nombre Empresa: ").append(getNombreEmpresa()).append('\n');
		sb.append("Especialidad: ").append(especialidad).append('\n');
		sb.append("Lenguaje de programación: ").append(lenguajeProgramacion);
		return sb.toString();
	 }

}
