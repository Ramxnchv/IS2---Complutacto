package Negocio.Empleado;

public class TEmpleado {
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected String telefono;
	protected String password;
	protected boolean activo;
	
	public TEmpleado(String dni, String nombre,String apellidos,String telefono, String password) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.password = password;
		activo = true;
	}
	
	public String getDNI() {
		return dni;
	}
	public String getPW() {
		return password;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setActivo(boolean x) {
		activo = x;
	}
}
