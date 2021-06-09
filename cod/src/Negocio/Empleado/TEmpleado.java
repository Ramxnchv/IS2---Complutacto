package Negocio.Empleado;

public class TEmpleado {
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected Integer telefono;
	protected String password;
	protected String dnisupervisor;
	protected boolean activo;
	
	public TEmpleado(String dni, String nombre,String apellidos,int telefono, String password, String dnisupervisor) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.password = password;
		this.dnisupervisor = dnisupervisor;
		activo = true;
	}
	
	public TEmpleado(String dni, String password) {
		this.dni = dni;
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
	
	public int getTelefono() {
		return telefono;
	}
	
	public String getDNISupervisor() {
		return dnisupervisor;
	}
	
	public void setDNISupervisor(String dnisupervisor) {
		this.dnisupervisor = dnisupervisor;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setActivo(boolean x) {
		activo = x;
	}
}
