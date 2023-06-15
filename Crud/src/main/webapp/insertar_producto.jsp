
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
 <link rel="stylesheet" href="Vista/Crud.css" type="text/css"><link>
  <link rel="stylesheet" href="Vista/regresar.css" type="text/css"><link>
  
</head>
<body class="body">

<div id="barrasuperior" class="Bsuperior" align="center" > 
<br>
<h1>Create Product</h1>
<br>
<br>
</div >

<div class="form1" align="center">
<form action="Crudcontroller"  name="create" method="get"  >
<input type="hidden" name="instruccion" value="create">

<table class="tabla" style="width:50%; border:0;" >

<tr>
 <td class="fila" width="27%">Seccion</td>
  <td class="fila" width="73%" ><label for="Seccion"></label>
  <input type="text" name="Seccion" id="Seccion">  </td>
 <tr>
<tr>
 <td class="fila" width="27%">Nombre</td>
  <td class="fila" width="73%" ><label for="nombre"></label>
  <input type="text" name="Nombre" id="Nombre">  </td>
 <tr>
 <td class="fila" width="27%">Precio</td>
  <td class="fila" width="73%" ><label for="Precio"></label>
  <input type="text" name="Precio" id="Precio">  </td>
 
</tr>
<tr>
 <td class="fila" width="27%">Importado</td>
  <td  class="fila" width="73%" ><label for="Importado"></label>
  <input type="text" name="Importado" id="Importado">  </td>
 
</tr>
<tr>
 <td class="fila" width="27%">Pais de origen</td>
  <td class="fila" width="73%" ><label for="Pais"></label>
  <input type="text" name="Pais" id="Pais">  </td>
 
</tr>
 
 <tr>
 <td  class="fila" width="27%">Fecha</td>
  <td class="fila" width="73%" ><label for="Fecha"></label>
  <input type="date" name="Fecha" id="Fecha">  </td>
 
</tr>
<tr>
  <td class="fila"><input type="submit" name="create" id="create" value="Create">  </td>
   <td class="fila"><input type="submit"name="restablecer" id="restablecer" value="Restablecer">  </td>
</tr>
</table>
</form>

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