//CLASE HIJA DE EMPLEADO, QUE HEREDA LOS ATRIBUTOS Y METODOS DE LA CLASE PADRE EMPLEADO
public class EmpleadoMarketing extends Empleado {
	
	//DEFINO LOS ATRIBUTOS DE ESTA CLASE 
	private int campanas;
	
	//CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE LA CLASE PADRE Y DE ESTA CLASE
	public EmpleadoMarketing(String nombre, String dni, double salario, String nombreEmpresa, int campanas) {
		
		//SUPER CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE LA CLASE PADRE
		super(nombre, dni, salario, nombreEmpresa);
		
		this.campanas = campanas;
	}
	
	//METODOS GET Y SET DE LAS VARIABLES DE ESTA CLASE
	public int getCampanas() {
		return campanas;
	}
	
	public void setCmapanas(int campanas) {
		this.campanas = campanas;
	}
	
	//AHORA SOBRE ESCRIBIMOS EL METODO TO STRING PARA MOSTRAR LOS DATOS DEL EMPLEADO DE MARKETING, AÑADIENDO LOS ATRIBUTOS DE ESTA CLASE
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ").append(getNombre()).append('\n');
		sb.append("DNI: ").append(getDni()).append('\n');
		sb.append("Salario: ").append(getSalario()).append('\n');
		sb.append("Nombre Empresa: ").append(getNombreEmpresa()).append('\n');
		sb.append("Campañas: ").append(campanas);
		return sb.toString();
	}

}
