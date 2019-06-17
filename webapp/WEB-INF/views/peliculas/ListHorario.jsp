<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de Horarios</title>

<spring:url value="/" var="urlRaiz"></spring:url>
<spring:url value="/resources/images/" var="urlImages"></spring:url>

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../helpers/header.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3>Listado de Horarios</h3>

		<a href="${urlRaiz}horarios/create" class="btn btn-success" role="button"
			title="Nueva Horario">Nuevo</a><br> <br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Pelicula</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>Sala</th>
					<th>Precio</th>
					<th>Opciones</th>
				</tr>

				<c:forEach items="${horarios}" var="horario">
					<tr>
						<td>
							<div >
								${horario.pelicula.titulo} <br> <img alt="${horario.pelicula.titulo}"
									src="${urlImages.concat(horario.pelicula.imagen)}" width="100">
							</div>
						</td>
						<td>${horario.fecha}</td>
						<td>${horario.hora}</td>
						<td>${horario.sala}</td>
						<td>${horario.precio}</td>
						<td><a href="#" class="btn btn-success btn-sm" role="button"
							title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="#" class="btn btn-danger btn-sm" role="button"
							title="Delete"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="../helpers/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->


</body>
</html>