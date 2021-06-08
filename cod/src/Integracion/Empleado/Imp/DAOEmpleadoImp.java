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
import Negocio.Cliente.TCliente;
import Negocio.Empleado.TEmpleado;

public class DAOEmpleadoImp implements DAOEmpleado {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url= "jdbc:mysql://localhost:3306/complutacto";
	private String user = "root";
	private String password = "";
	private PreparedStatement ps;
	
	
	@Override
	public TEmpleado leerEmpleadoDNI(String dni) throws SQLException {
		TEmpleado emp = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conexion=DriverManager.getConnection(url, user, password)) {
			ps = conexion.prepareStatement("select * from empleado where activo = '1' and dni=\"" + dni +" \"");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				emp = new TEmpleado(rs.getString(1), rs.getString(3),rs.getString(4),rs.getInt(5), rs.getString(2), rs.getString(6));
			} 
		} catch (SQLException e) {
			System.out.println("Error al intentar establecer conexion");
			e.printStackTrace();
		}
			return emp;
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
//		ResultSet rs = ps.executeQuery("select * from empleado where activo = '1' and nombre=" + nombre);
//		while(rs.next()) {
//			TEmpleado t = new TEmpleado(rs.getNString(1), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(2));
//			ret.add(t);
//		}
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
//		ResultSet rs = ps.executeQuery("select * from empleado where activo = '1' and apellidos=" + apellidos);
//		while(rs.next()) {
//			TEmpleado t = new TEmpleado(rs.getNString(1), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(2));
//			ret.add(t);
//		}
		return ret;
	}

	@Override
	public Collection <TEmpleado> leerEmpleados() throws SQLException {
		Collection<TEmpleado> ret = new ArrayList<>();
		TEmpleado emp = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conexion=DriverManager.getConnection(url, user, password)) {
			ps = conexion.prepareStatement("Select * from empleado where activo = '1'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TEmpleado t = new TEmpleado(rs.getString("dni"), rs.getString("nombre"), 
											rs.getString("apellidos"),rs.getInt("Telefono"),
											rs.getString("contraseña"), rs.getString("dni_supervisor"));
				ret.add(t);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al intentar establecer conexion");
			e.printStackTrace();
		}
		return ret;
	}

}
