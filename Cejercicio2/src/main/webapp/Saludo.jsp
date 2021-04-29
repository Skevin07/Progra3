<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>Datos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<div class="container ">
		<div class="row margen">
			<div class="col-md-12">
				<div class="panel panel-default sombra">
					<div class="panel-body">
						<div class="centrar">
							<h1></h1>
							<script type="text/javascript">
			  					$(document).ready(function (){
		  							$.post('ControllerMostrarInformacion',{
		  								
		  							}, function (response){		  							
		  								let datos = JSON.parse(response);
		  								console.log(datos);
		  								var tabla = document.getElementById('tablaDatos');
		  								for(let item of datos){
		  									
		  									tabla.innerHTML += `
		  										<tr>
		  											<td> ${item.idUsuario} </td>
		  											<td> ${item.Usuario} </td>
		  											<td> ${item.Pass} </td>
		  											<td> ${item.TipoUser} </td>
		  											<td> <a href="ControllerMostrarInformacion?IdUsuario=${item.idUsuario}&Eliminar=btne" class="btn btn-danger	">Eliminar </td>
		  											<a href="add.jsp?Id=${item.idUsuario}&Usuario=${item.Usuario}&Pass=${item.Pass}" class="btn btn-warning">Actualizar </a>
		  										</tr>																
		  									`	  								
		  									console.log(item.Pass);
		  								}
		  							});
		  						});
			  				</script>
			  				
			  				<%
			  				HttpSession sesion = (HttpSession) request.getSession();
			  				String usuSession = String.valueOf(sesion.getAttribute("usuario"));
			  				System.out.print(usuSession + "Nombre usuario");
			  				
			  				if (usuSession.equals(null)||usuSession.equals("null")){
			  					
			  					response.sendRedirect("index.jsp");
			  				}
			  				
			  				%>
			  				<form action="ControllerAcceso" method= "post">
			  				<input type="submit" name ="btncerrar" value="cerrar">
			  				</form>
			  				<a href ="add.jsp" class="btn btn-primary">Agregar</a>		  				
							<table id="tablaDatos" class="table table-striped">
								<thead>
									<tr>
										<th>IdUsuario</th>
										<th>Usuario</th>
										<th>Password</th>
										<th>Tipo</th>
										<th colspan="2">Acciones</th>
									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>