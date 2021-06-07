package Integracion.Empleado.Imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.ResultSet;
import Integracion.Empleado.DAOEmpleado;
import Negocio.Empleado.TEmpleado;

public class DAOEmpleadoImp implements DAOEmpleado {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url= "";
	private String user = "root";
	private String password = "MySQL";
	
	
	@Override
	public TEmpleado leerEmpleadoDNI(String dni) throws SQLException {
		try {
			Connection cn = DriverManager.getConnection(url, user, password);
			Statement ps = cn.createStatement();
		} catch (SQLException e) {
			System.out.println("Error al intentar establecer conexion");
			e.printStackTrace();
		}
		ResultSet rs = ps.executeQuery("select * from empleado where activo = '1' and dni=" + dni);
		return new TEmpleado(rs.getNString(1), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(2));
	}

	@Override
	public Collection<TEmpleado> leerEmpleadoNombre(String nombre) throws SQLException {
		Collection<TEmpleado> ret = new ArrayList<>();
		try {
			Connection cn = DriverManager.getConnection(url, user, password);
			Statement ps = cn.createStatement();
		} catch (SQLException e) {
			System.out.println("Error al intentar establecer conexion");
			e.printStackTrace();
		}
		ResultSet rs = ps.executeQuery("select * from empleado where activo = '1' and nombre=" + nombre);
		while(rs.next()) {
			TEmpleado t = new TEmpleado(rs.getNString(1), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(2));
			ret.add(t);
		}
		return ret;
	}

	@Override
	public Collection<TEmpleado> leerEmpleadoApellidos(String apellidos) throws SQLException {
		Collection<TEmpleado> ret = new ArrayList<>();
		try {
			Connection cn = DriverManager.getConnection(url, user, password);
			Statement ps = cn.createStatement();
		} catch (SQLException e) {
			System.out.println("Error al intentar establecer conexion");
			e.printStackTrace();
		}
		ResultSet rs = ps.executeQuery("select * from empleado where activo = '1' and apellidos=" + apellidos);
		while(rs.next()) {
			TEmpleado t = new TEmpleado(rs.getNString(1), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(2));
			ret.add(t);
		}
		return ret;
	}

	@Override
	public Collection <TEmpleado> leerEmpleados() throws SQLException {
		Collection<TEmpleado> ret = new ArrayList<>();
		try {
			Connection cn = DriverManager.getConnection(url, user, password);
			Statement ps = cn.createStatement();
		} catch (SQLException e) {
			System.out.println("Error al intentar establecer conexion");
			e.printStackTrace();
		}
		ResultSet rs = ps.executeQuery("Select * from empleado where activo = '1' ");
		while(rs.next()) {
			TEmpleado t = new TEmpleado(rs.getNString(1), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(2));
			ret.add(t);
		}
		return ret;
	}

}
