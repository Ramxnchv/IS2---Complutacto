//package Negocio.Tarifa.Imp;
//
//import java.util.Collection;
//
//import Negocio.Tarifa.SATarifa;
//import Negocio.Tarifa.TTarifa;
//
//public class SATarifaImp implements SATarifa {
//	protected FactoriaIntegracion factoria;
//	protected DAOTarifa daoTarifa;
//	public SATarifaImp() {
//		factoria = FactoriaIntegracionImp.getInstance();
//		daoTarifa = factoria.generarDAOTarifa();
//	}
//	@Override
//	public boolean anadirTarifa(int id, String nombre, double precio) throws Exception {
//		boolean ret = false;
//		TTarifa tarifa = daoTarifa.leerTarifaPorID(id);
//		if(tarifa == null) {
//			tarifa = new TTarifa (id, nombre, precio);
//			
//		}
//		else {
//			throw new Exception("Existe la tarifa con id: " + id);
//		}
//		return true;
//	}
//	@Override
//	public boolean borrarTarifa(int id) throws Exception {
//		boolean ret = false;
//		TTarifa tarifa = daoTarifa.leerTarifaPorID(id);
//		if(tarifa != null) {
//			tarifa.setActivo(false);			
//		}
//		else {
//			throw new Exception("No existe la tarifa con id: " + id);
//		}
//		return true;
//	}
//	@Override
//	public boolean modificarTarifa(TTarifa tarifa) throws Exception {
//		boolean ret = false;
//		TTarifa tarifaB = daoTarifa.leerTarifaPorID(tarifa.getID());
//		if(tarifaB != null) {
//			tarifaB.setNombre(tarifa.getNombre());
//			tarifaB.setPrecio(tarifa.getPrecio());
//		}
//		else {
//			throw new Exception("No existe la tarifa con id: " + id);
//		}
//		return true;
//	}
//	@Override
//	public TTarifa mostrarTarifa(int id) throws Exception {
//		TTarifa tarifa= daoTarifa.leerTarifaPorID(id);
//		return tarifa;
//	}
//	@Override
//	public Collection<TTarifa> mostrarTodos() throws Exception {
//		return daoTarifa.leerTarifa();
//	}
//
//
//
//}
