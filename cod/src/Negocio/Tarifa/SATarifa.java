package Negocio.Tarifa;

import java.util.Collection;

public interface SATarifa {
	public boolean anadirTarifa(int id, String nombre, double precio) throws Exception;
	public boolean borrarTarifa(int id)throws Exception;
	public boolean modificarTarifa(TTarifa tarifa)throws Exception;
	public TTarifa mostrarTarifa(int id)throws Exception;
	public Collection<TTarifa> mostrarTodos()throws Exception;


}
