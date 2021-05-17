
package Negocio.Tarifa;

public class TTarifa {
	private int id;
	private String nombre;
	private double precio;
	private boolean activo;
	public TTarifa(int id, String nombre, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.activo = true;
		
	}
	public int getID() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activar) {
		activo = activar;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
