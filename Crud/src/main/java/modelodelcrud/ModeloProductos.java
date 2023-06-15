package modelodelcrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
	private Connection cone;
	private DataSource datasource;
	
	public ModeloProductos(DataSource datasource) {
		super();
		this.datasource = datasource;
		
	}
	

	
	public List<Producto> getproductos() throws SQLException{
		
		List <Producto> productos= new ArrayList<Producto>();
		cone=datasource.getConnection();
		Statement statement= cone.createStatement();
		ResultSet resultado= statement.executeQuery("SELECT * FROM productos");

		while(resultado.next()) {
			Producto producto= new Producto();
			producto.setId(resultado.getString(1));
			producto.setNombre(resultado.getString(3));
			producto.setSeccion(resultado.getString(2));
			producto.setPrecio(resultado.getDouble(4));
			producto.setPaisorigen(resultado.getString(7));
			producto.setFecha(resultado.getDate(5));
			producto.setImportado(resultado.getString(6));
	
			productos.add(producto);
			
		}
		
		statement.close();
		resultado.close();
		cone.close();
		
		if(productos.size()!=0) {
			return productos;
		}
		else {
			return null;
		}
		
	}
	
	
	public void create(Producto p) {
		
		try {
		
			
			// obtener la conexion con el pool
				
			cone=datasource.getConnection();
			// crear instruccion sql
			PreparedStatement Pstate=cone.prepareStatement("INSERT INTO `productos`(`NOMBREARTICULO`,`SECCION`,`FECHA`,"
					+ "`PRECIO`,`PAIS DE ORIGEN`,`IMPORTADO`) Values(?,?,?,?,?,?)");
			
			//establecer parametros
			Pstate.setString(1,p.getNombre());
			Pstate.setString(2,p.getSeccion());
			Pstate.setDate(3,p.getFecha());
			Pstate.setDouble(4,p.getPrecio());
			Pstate.setString(5, p.getPaisorigen());
			Pstate.setString(6, p.getImportado());
			
			//ejecutar la instruccion sql
			Pstate.execute();
		
			Pstate.close();
			cone.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}



	public Producto getbyID(String parameter) {
		

		try {
			Producto producto= new Producto();
			cone=datasource.getConnection();
			PreparedStatement Pstatement= cone.prepareStatement("SELECT * from `productos` where `codigo`=?");
			Pstatement.setString(1, parameter);
			ResultSet resultado=Pstatement.executeQuery();
			
			
			while(resultado.next()) {
					producto.setId(resultado.getString(1));
					producto.setNombre(resultado.getString(3));
					producto.setSeccion(resultado.getString(2));
					producto.setPrecio(resultado.getDouble(4));
					producto.setPaisorigen(resultado.getString(7));
					producto.setFecha(resultado.getDate(5));
					producto.setImportado(resultado.getString(6));
					
				}
			
			Pstatement.close();
			resultado.close();
			cone.close();
			return producto;
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
		
	}



	public void updatepoducto(Producto p) {
		try {
			// obtener la conexion con el pool
			cone= datasource.getConnection();
			
			
			// crear instruccion sql
			PreparedStatement Pstate=cone.prepareStatement("UPDATE `productos` set `NOMBREARTICULO`=?,`SECCION`=?,`FECHA`=?,"
						+ "`PRECIO`=?,`PAIS DE ORIGEN`=?,`IMPORTADO`=? WHERE `CODIGO`=?");
			
			//establecer parametros
			Pstate.setString(1,p.getNombre());
			Pstate.setString(2,p.getSeccion());
			Pstate.setDate(3,p.getFecha());
			Pstate.setDouble(4,p.getPrecio());
			Pstate.setString(5, p.getPaisorigen());
			Pstate.setString(6, p.getImportado());
			Pstate.setString(7, p.getId());
			
			//ejecutar la instruccion sql
			Pstate.execute();
			
			Pstate.close();
			cone.close();
			
			}
		catch (SQLException e) {
			e.printStackTrace();
			}
		}



	public void eliminarproducto(String id) {
		
		try {
			// obtener la conexion con el pool
			cone= datasource.getConnection();
			
			// crear instruccion sql
			PreparedStatement Pstate=cone.prepareStatement("DELETE FROM `productos` WHERE `CODIGO`=?");
			
			//establecer el id
			Pstate.setString(1,id);
	
			//ejecutar la instruccion sql
			Pstate.execute();
			
			Pstate.close();
			cone.close();
			
			}
		catch (SQLException e) {
			e.printStackTrace();
			}
		}


	
}
