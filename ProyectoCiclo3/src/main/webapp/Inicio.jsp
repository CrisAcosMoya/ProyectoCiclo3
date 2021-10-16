<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="container mt-4 col-lg-4" >
  <div class="card col-sm-10">
    <div class="card-body">
      <form class="form-sign" method="get" action="./ControllerServlet">
        <div class="form-group text-center" >
         <h3>Login</h3>
         <img src="imagen/login.jpg" width="40" alt="40">
         <label>Bienvenidos al Sistema</label>
        </div>
        <div class="form-group">
         <label>Usuario:</label>
         <input type="text" name="txtusuario" class="form-control">
        </div>
        <div class="form-group">
        <label>Password:</label>
         <input type="password" name="txtpassword" class="form-control">
        </div>
                <input type="submit" name="accion" value="Ingresar" class="btn btn-primary">
      </form>
    </div>
  </div>
 </div>
</body>
</html>