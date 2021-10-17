<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.ciclo3demo.Productos"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Productos</title>
</head>
<body>
<div class="row">
   <div class="card col-md-4">
       <div class="card-body">
           <h5 class="card-title">Productos</h5>
           <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los usuarios del sistema</h6>
           <div>
     		 <form class="form-sign" method="get" action="Controlador">
      		      
		        <div class="form-group">
		         <input type="hidden" name="menu" value="Productos">
		         <label>Codigo:</label>
		         <input type="text" name="txtcodigo" class="form-control" value="${usuarioSeleccionado.getCodigo_producto()}">
		        </div>
		        <div class="form-group">
		         <label>Nombre Producto:</label>
		                  <input type="text" name="txtnombre" class="form-control" value="${usuarioSeleccionado.getNombre_producto()}">
		        </div>
		        <div class="form-group">
		         <label>Nit:</label>
		         <input type="text" name="txtnit" class="form-control" value="${usuarioSeleccionado.getNit_proveedor()}">
		        </div>
		        <div class="form-group">
		         <label>Precio Compra:</label>
		         <input type="text" name="txtprecio" class="form-control" value="${usuarioSeleccionado.getPrecio_compra()}">
                   </div>
		        <div class="form-group">
		        <label>Iva:</label>
		         <input type="text" name="txtiva" class="form-control" value="${usuarioSeleccionado.getIvacompra()}">
		        </div>
		       	<div class="form-group">
		        <label>Precio Venta:</label>
		         <input type="text" name="txtprecio" class="form-control" value="${usuarioSeleccionado.getPrecio_venta()}">
		        </div>
		        <input type="submit" class="btn btn-primary" name="accion" value="Consultar">
		        
       	 </form>
    </div>
  </div>
  </div>
 <div class="col-md-8">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Codigo</th>
                <th scope="col">Nombre Producto</th>
                <th scope="col">Nit</th>
                <th scope="col">Precio Compra</th>
                <th scope="col">Iva</th>
                <th scope="col">Precio Venta</th>
           </tr>
        </thead>
        <tbody>
            <% ArrayList<Productos> lista= (ArrayList<Productos>) request.getAttribute("lista");
			for (Productos producto:lista){
			%>
			<tr>
				<td><%=producto.getCodigo_producto()%></td>
				<td><%=producto.getNombre_producto()%></td>
				<td><%=producto.getNit_proveedor()%></td>
				<td><%=producto.getPrecio_compra()%></td>
				<td><%=producto.getIvacompra()%></td>
				<td><%=producto.getPrecio_venta()%></td>
				<td> 
	               <a class="btn btn-warning" href="Controlador?menu=Productos&accion=Cargar&id=<%=producto.getCodigo_producto()%>">Editar</a>
	               <a class="btn btn-danger" href="Controlador?menu=Productos&accion=Eliminar&id=<%=producto.getCodigo_producto()%>">Eliminar</a>
            	</td>
            </tr>
            <%}%>
        </tbody>
    </table>
</div>
<!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script> </body> </html>