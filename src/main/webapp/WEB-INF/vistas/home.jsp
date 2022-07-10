<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<h1>Ejercicio Can Do It</h1>
		</div>
		<div class="container">
				<table class="table">
					<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Localidad</th>
						<th scope="col">Provincia</th>
						<th scope="col">Temperatura</th>
					</tr>
					</thead>
					<c:forEach var="ciud" items="${ciudades}">
					<tbody>
					<tr>
						<td>${ciud.id}</td>
						<td>${ciud.localidad}</td>
						<td>${ciud.provincia}</td>
						<td>${ciud.temperatura}</td>
					</tr>
					</tbody>
					</c:forEach>
				</table>

		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>