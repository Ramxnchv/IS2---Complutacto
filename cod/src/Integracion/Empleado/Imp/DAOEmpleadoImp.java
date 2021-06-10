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
				emp = new TEmpleado(rs.getString("dni"), rs.getString("nombre"), 
						rs.getString("apellidos"),rs.getInt("Telefono"),
						rs.getString("contraseña"), rs.getString("dni_supervisor"));
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
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conexion=DriverManager.getConnection(url, user, password)) {
			ps = conexion.prepareStatement("Select * from empleado where activo = '1' and nombre= " + nombre);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TEmpleado t = new TEmpleado(rs.getString("dni"), rs.getString("nombre"), 
											rs.getString("apellidos"),rs.getInt("Telefono"),
											rs.getString("contraseña"), rs.getString("dni_supervisor"));
				ret.add(t);
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Error al intentar establecer conexion");
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Collection<TEmpleado> leerEmpleadoApellidos(String apellidos) throws SQLException {
		Collection<TEmpleado> ret = new ArrayList<>();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conexion=DriverManager.getConnection(url, user, password)) {
			ps = conexion.prepareStatement("Select * from empleado where activo = '1' and apellidos = " + apellidos);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TEmpleado t = new TEmpleado(rs.getString("dni"), rs.getString("nombre"), 
											rs.getString("apellidos"),rs.getInt("Telefono"),
											rs.getString("contraseña"), rs.getString("dni_supervisor"));
				ret.add(t);
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Error al intentar establecer conexion");
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Collection <TEmpleado> leerEmpleados() throws SQLException {
		Collection<TEmpleado> ret = new ArrayList<>();
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
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Error al intentar establecer conexion");
			e.printStackTrace();
		}
		return ret;
	}

}
