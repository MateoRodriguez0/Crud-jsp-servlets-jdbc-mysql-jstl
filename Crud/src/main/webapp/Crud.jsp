<%@page import="modelodelcrud.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud </title>
 <link rel="stylesheet" href="Vista\estilos.css" type="text/css"><link>
 <link rel="stylesheet" href="Vista\Botones.css" type="text/css"><link>
 
</head>
<body class="body">

<div id="barrasuperior" class="Bsuperior" align="center" > 
<br>
<h1>Crud: mysql, jsp, pildorasinformaticas</h1>
<br>
<br>
<br>
</div >

<div class="Ptabla" align="center">
<br>
<h2 style="color: #FACC2E">Lista de productos</h2>


<table class="tabla" >
<thead>
<tr class="encabezado" >
	<th>Id</th><th>Seccion</th><th>Nombre</th><th>Precio</th><th>Pais de origen</th><th>Fecha </th><th>Importado</th><th>Update</th><th>Delete</th>
	</tr>
</thead>

<tbody>

	<c:forEach var="p" items="${Lista_productos}">
	
	<!--link para cada producto con su campo clave-->
	<c:url var="goupdate" value="Crudcontroller" >
		<c:param name="instruccion" value="llenarcampos"></c:param>
		<c:param name="ID" value="${p.id}"></c:param>
	</c:url>
		<c:url var="godelete" value="Crudcontroller" >
		<c:param name="instruccion" value="llenarcampos2"></c:param>
		<c:param name="ID2" value="${p.id}"></c:param>
	</c:url>

	<tr class="filas">
	<td class="sinBorde">${p.id}  </td>
	<td class="sinBorde">${p.seccion} </td>
	<td class="sinBorde">${p.nombre} </td>
	<td class="sinBorde">${p.precio}</td>
	<td class="sinBorde">${p.paisorigen}</td>
	<td class="sinBorde">${p.fecha} </td>
	<td class="sinBorde">${p.importado} </td>
	<td class="sinBorde"><a id="opcion1" href="${goupdate }">Update</a> </td>
	<td class="sinBorde"><a id="opcion2" href="${godelete}">Delete</a> </td>
	</tr>
	
	</c:forEach>

</tbody>
</table>

</div>

<div id="b1">
  <section class="bg-dark btn-container">
  
  <div class="btn-item" >
    <a href="insertar_producto.jsp" class="btn-ghost purple secundary round"  >Create product</a>
  </div>
  
  <div class="btn-item">
    <a href="Actualizar.jsp" class="btn-ghost yellow secundary round" >Update product</a>
  </div>
  
  <div class="btn-item">
    <a href="Eliminar.jsp" class="btn-ghost green secundary round" >Delete product</a>
  </div>
  
 
</section>
</div>



</body>
</html>