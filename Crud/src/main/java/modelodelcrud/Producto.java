package modelodelcrud;

import java.sql.Date;

public class Producto {

	public Producto(String id, String seccion, String nombre, String importado, String paisorigen, double precio,
			Date fecha) {
		super();
		this.id = id;
		this.seccion = seccion;
		this.nombre = nombre;
		this.importado = importado;
		this.paisorigen = paisorigen;
		this.precio = precio;
		this.fecha = fecha;
	}	
	public Producto( String seccion, String nombre, String importado, String paisorigen, double precio,
			Date fecha) {
		super();
		this.seccion = seccion;
		this.nombre = nombre;
		this.importado = importado;
		this.paisorigen = paisorigen;
		this.precio = precio;
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImportado() {
		return importado;
	}
	public void setImportado(String importado) {
		this.importado = importado;
	}
	public String getPaisorigen() {
		return paisorigen;
	}
	public void setPaisorigen(String paisorigen) {
		this.paisorigen = paisorigen;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	private String id,seccion,nombre,importado, paisorigen;
	private double precio;
	private Date fecha;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "el articulo "+nombre+" pretenece a la categoria "+ seccion+" y tiene un precio de "+precio;
	}

}
