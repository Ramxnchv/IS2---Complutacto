package Negocio.Cliente;

public class TCliente {
	private String DNI;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String DNI_empleado;
	private boolean activo;
	
	public TCliente(String dni, String nombre, String apellidos, String direccion, String dni_empleado,boolean activo) {
		this.DNI = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.DNI_empleado = dni_empleado;
		this.activo = activo;
	}
	
	public TCliente(String dni,String nombre) {
		this.DNI=dni;
		this.nombre=nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getDNI_empleado() {
		return DNI_empleado;
	}
	
	
	
}
