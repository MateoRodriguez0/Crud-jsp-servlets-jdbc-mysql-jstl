
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
  <link rel="stylesheet" href="Vista/Crud.css" type="text/css"><link>
  <link rel="stylesheet" href="Vista/regresar.css" type="text/css"><link>
  
  
</head>
<body class="body">

<div id="barrasuperior" class="Bsuperior" align="center" style="color:#19547b; font-family: 'Montserrat', sans-serif;"> 
<br>
<h1>Update Product</h1>
<br>
<br>
</div >

<div class="form1" align="center">
<form name="create" method="get" action="Crudcontroller" >
<input type="hidden" name="instruccion" value="update">


<c:choose>
<c:when test="${producto_update!=null}">
<input type="hidden" name="Prodcuto_update" value="${producto_update}">
<c:set var="id" value="${producto_update.id}"></c:set>
<c:set var="nombre" value="${producto_update.nombre}"></c:set>
<c:set var="seccion" value="${producto_update.seccion}"></c:set>
<c:set var="pais" value="${producto_update.paisorigen}"></c:set>
<c:set var="precio" value="${producto_update.precio}"></c:set>
<c:set var="fecha" value="${producto_update.fecha}"></c:set>
<c:set var="importado" value="${producto_update.importado}"></c:set>

</c:when>
<c:otherwise>
<c:set var="id" value=""></c:set>
<c:set var="nombre" value=""></c:set>
<c:set var="seccion" value=""></c:set>
<c:set var="pais" value=""></c:set>
<c:set var="precio" value=""></c:set>
<c:set var="fecha" value=""></c:set>
<c:set var="importado" value=""></c:set>
</c:otherwise>
</c:choose>

<table class="tabla" style="width:50%; border:0;" >


<tr>
 <td class="fila" width="27%">Id de producto</td>
  <td class="fila" width="73%" ><label for="Id"></label>
  <input type="text" name="Id" id="Id"value="${id}">  </td>
 
</tr>

<tr>
 <td class="fila" width="27%">Nombre</td>
  <td class="fila" width="73%" ><label for="nombre"></label>
  <input type="text" name="Nombre" id="nombre"value="${nombre}">  </td>
 
</tr>
<tr>
 <td class="fila" width="27%">Seccion</td>
  <td class="fila" width="73%" ><label for="Seccion"></label>
  <input type="text" name="Seccion" id="Seccion" value="${seccion }"> </td>
 
</tr><tr>
 <td  class="fila" width="27%">Fecha</td>
  <td class="fila" width="73%" ><label for="fecha"></label>
  <input type="date" name="Fecha" id="fecha"value="${fecha}">  </td>
 
</tr><tr>
 <td class="fila" width="27%">Precio</td>
  <td class="fila" width="73%" ><label for="Precio"></label>
  <input type="text" name="Precio" id="Precio"value="${precio}">  </td>
 
</tr>
<tr>
 <td class="fila" width="27%">Importado</td>
  <td  class="fila" width="73%" ><label for="Importado"></label>
  <input type="text" name="Importado" id="Importado"value="${importado}">  </td>
 
</tr>
<tr>
 <td class="fila" width="27%">Pais de origen</td>
  <td class="fila" width="73%" ><label for="Pais"></label>
  <input type="text" name="Pais" id="Pais"value="${pais}">  </td>
 
</tr>

</table>
<div>
<input type="submit"name="restablecer" id="restablecer" value="Update"class="btn-ghost purple secundary round"> 
</div>
</form>

</div>



<div class="regresar">
  <section class="bg-dark btn-container">
  <div class="btn-item" >
    <input type="submit" value="Read"  onclick="window.history.back()"class="btn-ghost purple secundary round">
  </div>
 
</section>
</div>


<div class="regresar">
  <section class="bg-dark btn-container">
  <div class="btn-item" >
    <input type="submit" value="Read"  onclick="window.history.back()"class="btn-ghost purple secundary round">
  </div>
 
</section>
</div>


</body>
</html>