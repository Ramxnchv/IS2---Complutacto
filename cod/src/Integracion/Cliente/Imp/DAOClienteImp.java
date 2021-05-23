package Integracion.Cliente.Imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.SQLException;
import java.sql.Statement;

import Integracion.Cliente.DAOCliente;
import Negocio.Cliente.TCliente;

public class DAOClienteImp implements DAOCliente {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost/complutacto";
	private String user = "root";
	private String pass = "";
	private PreparedStatement ps;

	@Override
	public TCliente leerPorNombre(String Nombre) {
		// TODO Auto-generated method stub
				TCliente cliente = null;

				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try (Connection conexion = DriverManager.getConnection(url, user, pass)) {

					ps = conexion.prepareStatement(
							"SELECT cliente.dni, cliente.nombre, cliente.apellidos, cliente.direccion, cliente.dni_empleado, cliente.activo FROM cliente WHERE activo='1' AND nombre="
									+ "'" + Nombre + "'");

					ResultSet rs = ps.executeQuery();

					if (rs.next()) {

						cliente = new TCliente(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"),
								rs.getString("direccion"), rs.getString("dni_empleado"), rs.getBoolean("activo"));

					}

					rs.close();
					ps.close();

				} catch (Exception e) {
					e.getMessage();
				}

				return cliente;
	}

	@Override
	public TCliente leerPorID(int dni) {
		// TODO Auto-generated method stub
		TCliente cliente = null;

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conexion = DriverManager.getConnection(url, user, pass)) {

			ps = conexion.prepareStatement(
					"SELECT cliente.dni, cliente.nombre, cliente.apellidos, cliente.direccion, cliente.dni_empleado, cliente.activo FROM cliente WHERE activo='1' AND dni="
							+ "'" + dni + "'");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				cliente = new TCliente(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("direccion"), rs.getString("dni_empleado"), rs.getBoolean("activo"));

			}

			rs.close();
			ps.close();

		} catch (Exception e) {
			e.getMessage();
		}

		return cliente;
	}

	@Override
	public Collection<TCliente> leerTodos() {
		// TODO Auto-generated method stub
				Collection <TCliente> clientes= new ArrayList<TCliente>();

				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try (Connection conexion = DriverManager.getConnection(url, user, pass)) {

					ps = conexion.prepareStatement("SELECT * FROM cliente WHERE activo = 1 ");

					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						TCliente c;
						
						c = new TCliente(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"),
								rs.getString("direccion"), rs.getString("dni_empleado"), rs.getBoolean("activo"));
						
						clientes.add(c);
					}

					rs.close();
					ps.close();

				} catch (Exception e) {
					e.getMessage();
				}

				return clientes;
	}

	@Override
	public void altaCliente(TCliente cliente) throws Exception {
		// TODO Auto-generated method stub
		Connection conexion=DriverManager.getConnection(url, user, pass);
		Class.forName(driver);
		ps = conexion.prepareStatement("INSERT INTO cliente (dni,nombre,apellidos,direccion,dni_empleado,activo) VALUES (?,?,?,?,?,1)",Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cliente.getDNI());
		ps.setString(2, cliente.getNombre());
		ps.setString(3, cliente.getApellidos());
		ps.setString(4, cliente.getDireccion());
		ps.setString(5, cliente.getDNI_empleado());
		ps.executeUpdate();
	}

	@Override
	public void actualizarCliente(TCliente cliente) {
		// TODO Auto-generated method stub
		
		try(Connection conexion=DriverManager.getConnection(url, user, pass)){
			Class.forName(driver);
			int act = (cliente.isActivo() ? 1 : 0);
			ps=conexion.prepareStatement("UPDATE cliente SET nombre='"+cliente.getNombre()+"', apellidos='"+cliente.getApellidos()+"', direccion= '"+cliente.getDireccion()+"' ,dni_empleado='"+cliente.getDNI_empleado()+"', ACTIVO='"+act+"' WHERE dni="+cliente.getDNI());
			ps.executeUpdate();
            
			}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			e.getMessage();
		}	
	}

}
