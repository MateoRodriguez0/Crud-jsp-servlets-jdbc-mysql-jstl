package controlador_del_crud;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import modelodelcrud.ModeloProductos;
import modelodelcrud.Producto;

/**
 * Servlet implementation class Crudcontroller
 */
@WebServlet("/Crudcontroller")
public class Crudcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModeloProductos Bodega;

	@Resource(name = "jdbc/productos")
	private DataSource datasource;
    
    

	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
		Bodega= new ModeloProductos(datasource);
		
		}catch (Exception e) {
			e.getMessage();
		}
		
	}




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		

		//leer el parametro
		String instrucccion= (String) request.getParameter("instruccion");
		if(instrucccion==null) {
			instrucccion="read";
		}
		
		switch (instrucccion) {
		case "read": {
			obtenerproductos(request, response);
			break;
		}
		
		case "create":{
			created(request, response);
			break;
		}
		case "update":{
			actualizarproducto(request,response);
			break;
		}case "delete":{
			try {
				eliminarproducto(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		case "llenarcampos":{
			try {
				gotoupdate(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}		
		case "llenarcampos2":{
			try {
				gotodelete(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			break;
		}
		
		default:
			obtenerproductos(request, response);
		}
		
	}




	private void gotodelete(HttpServletRequest request, HttpServletResponse response)throws Exception {
		//ler el codigo articulo
		
		//Enviar codigo del articulo al modelo 
		
		Producto producto=Bodega.getbyID((String)request.getParameter("ID2"));
		
		
		request.setAttribute("producto_delete", producto);
		
		//obtener los datos del registro 
		RequestDispatcher Rdist= request.getRequestDispatcher("Eliminar.jsp");
		
		//cargar cada campo de  la interfaz con los datos 
		Rdist.forward(request, response);
		
		
	}




	private void eliminarproducto(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		// capturar el codigo articulo
		String id=request.getParameter("Id");
		//borrar el producto de la base de datos
		Bodega.eliminarproducto(id);
		
		//volver al listado
		obtenerproductos(request, response);
	}




	private void actualizarproducto(HttpServletRequest request, HttpServletResponse response) {
		
		
		//leer los datos que le vienen del formulario
		String id=request.getParameter("Id");
		String nombre=request.getParameter("Nombre");
		String seccion=request.getParameter("Seccion");
		String pais=request.getParameter("Pais");
		String importado=request.getParameter("Importado");
		double precio= Double.valueOf( request.getParameter("Precio"));
		Date fecha=null;
		SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
		try {
			 java.util.Date fechad= formatofecha.parse(request.getParameter("Fecha"));
			 long timeInMilliSeconds = fechad.getTime();
			 fecha= new Date(timeInMilliSeconds);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		

		// crear un objeto con la info del formulario
		Producto produ= new Producto();
		produ.setId(id);
		produ.setNombre(nombre);
		produ.setSeccion(seccion);
		produ.setImportado(importado);
		produ.setFecha(fecha);
		produ.setPrecio(precio);
		produ.setPaisorigen(pais);
	
		
		//actualizar la base de datos 
		Bodega.updatepoducto(produ);
		
		//cargar la interfaz con la informacion actualizada
		
		obtenerproductos(request, response);
		
	}




	private void gotoupdate(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//ler el codigo articulo
		
		//Enviar codigo del articulo al modelo 
		
		Producto producto=Bodega.getbyID((String)request.getParameter("ID"));
		
		
		request.setAttribute("producto_update", producto);
		
		//obtener los datos del registro 
		RequestDispatcher Rdist= request.getRequestDispatcher("Actualizar.jsp");
		
		//cargar cada campo de  la interfaz con los datos 
		Rdist.forward(request, response);
		
		

		
	}




	private void obtenerproductos(HttpServletRequest request, HttpServletResponse response) {
		//obtener la lista de productos
		
		List<Producto> productosenbodega=null;
		try {
		
			productosenbodega= Bodega.getproductos();
			
			
			//agregar la lista al request
			
			request.setAttribute("Lista_productos", productosenbodega);
			
			//enviar el request a la pagina jsp
			
			RequestDispatcher paquete= request.getRequestDispatcher("Crud.jsp");
			
			paquete.forward(request, response);
			
			
		} catch (SQLException | ServletException | IOException e) {
		
			e.printStackTrace();
		}
		
	}

	
	private void created(HttpServletRequest request, HttpServletResponse response) {
		
		//leer la informacion del producto del formulario
		String seccion,nombre,pais, importado;
		double precio;
	    Date fecha=null;
		SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
		
		seccion=request.getParameter("Seccion");
		nombre=request.getParameter("Nombre");
		pais=request.getParameter("Pais");
		importado=request.getParameter("Importado");
		precio=Double.valueOf(request.getParameter("Precio"));
		try {
			 java.util.Date fechad= formatofecha.parse(request.getParameter("Fecha"));
			 long timeInMilliSeconds = fechad.getTime();
			 fecha= new Date(timeInMilliSeconds);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		//crear un objeto de tipo producto
		Producto produc= new Producto();
		produc.setNombre(nombre);
		produc.setSeccion(seccion);
		produc.setPaisorigen(pais);
		produc.setPrecio(precio);
		produc.setImportado(importado);
		produc.setFecha(fecha);
		
		//enviar el objeto al modelo
		Bodega.create(produc);
		
		
		// volver a listar la tabla de productos
		
		obtenerproductos(request, response);
		
	}

}
