package controlador_del_crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Servletcrud1
 */
@WebServlet("/Servletcrud1")
public class Servletcrud1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// definir o establecer el datasource
	
	@Resource(name = "jdbc/productos")
	private DataSource pool;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletcrud1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//crear el objeto Printwriter
		
		PrintWriter res= response.getWriter();
		
		response.setContentType("text/plain");
		
		//crear la conexion con la bbdd
		
		Connection mycon=null;
		Statement sta=null; 
		ResultSet resul= null;
		
		try {
			mycon=pool.getConnection();
			sta=mycon.createStatement();
			resul=sta.executeQuery("SELECT * FROM productos");
			while(resul.next()) {
				res.println(resul.getString(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
