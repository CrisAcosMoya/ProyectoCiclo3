<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.ciclo3demo.Ventas"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Ventas</title>
</head>
<body>
<div class="row">
   <div class="card col-md-4">
       <div class="card-body">
           <h5 class="card-title">Ventas</h5>
           <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los usuarios del sistema</h6>
           <div>
     		 <form class="form-sign" method="get" action="Controlador">
      		      
		        <div class="form-group">
		         <input type="hidden" name="menu" value="Ventas">
		         <label>Codigo Venta:</label>
		         <input type="text" name="txtcodigo" class="form-control" value="${usuarioSeleccionado.getCodigo_venta()}">
		        </div>
		        <div class="form-group">
		         <label>Cedula Cliente:</label>
		                  <input type="text" name="txtcedulacliente" class="form-control" value="${usuarioSeleccionado.getCedula_cliente()}">
		        </div>
		        <div class="form-group">
		         <label>Cedula Usuario:</label>
		         <input type="text" name="txtcedulausuario" class="form-control" value="${usuarioSeleccionado.getCedula_usuario()}">
		        </div>
		        <div class="form-group">
		         <label>Iva:</label>
		         <input type="text" name="txtivaventa" class="form-control" value="${usuarioSeleccionado.getIva_venta()}">
                   </div>
		        <div class="form-group">
		        <label>Total Venta:</label>
		         <input type="text" name="txttotal" class="form-control" value="${usuarioSeleccionado.getTotal_venta()}">
		        </div>
		       	<div class="form-group">
		        <label>Valor Venta:</label>
		         <input type="text" name="txtvalor" class="form-control" value="${usuarioSeleccionado.getValor_venta()}">
		        </div>
		        <input type="submit" class="btn btn-primary" name="accion" value="Cosultar">
		        
       	 </form>
    </div>
  </div>
  </div>
 <div class="col-md-8">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Codigo Venta</th>
                <th scope="col">Cedula Cliente</th>
                <th scope="col">Cedula Usuario</th>
                <th scope="col">Iva</th>
                <th scope="col">Total Venta</th>
                <th scope="col">Valor Venta</th>
           </tr>
        </thead>
        <tbody>
            <% ArrayList<Ventas> lista= (ArrayList<Ventas>) request.getAttribute("lista");
			for (Ventas venta:lista){
			%>
			<tr>
				<td><%=venta.getCodigo_venta()%></td>
				<td><%=venta.getCedula_cliente()%></td>
				<td><%=venta.getCedula_usuario()%></td>
				<td><%=venta.getIva_venta()%></td>
				<td><%=venta.getTotal_venta()%></td>
				<td><%=venta.getValor_venta()%></td>
				<td> 
	               <a class="btn btn-warning" href="Controlador?menu=Ventas&accion=Cargar&id=<%=venta.getCodigo_venta()%>">Editar</a>
	               <a class="btn btn-danger" href="Controlador?menu=Ventas&accion=Eliminar&id=<%=venta.getCodigo_venta()%>">Eliminar</a>
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