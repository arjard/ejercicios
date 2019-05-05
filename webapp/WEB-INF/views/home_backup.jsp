<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CinemaApp</title>

<spring:url value="/resources" var="urlResources"></spring:url>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="${urlResources}/css/bootstrap.min.css">

<body>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Tabla de peliculas</div>
			<div class="panel-body">
				<table border="1"
					class="table table-striped table-bordered table-hover">
					<thead class="thead-dark">
						<tr>
							<td>Id</td>
							<td>Titulo</td>
							<td>Duracion</td>
							<td>Clasificacion</td>
							<td>Genero</td>
							<td>Estreno</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pelicula" items="${peliculas}">
							<tr>
								<td>${pelicula.id}</td>
								<td>${pelicula.titulo}</td>
								<td>${pelicula.duracion}min</td>
								<td>${pelicula.clasificacion}</td>
								<td>${pelicula.genero}</td>
								<td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/></td>
								<td><img width="100px" alt="${pelicula.titulo}" src="${urlResources}/images/${pelicula.imagen}"></td>
								<td>
									
									<c:choose>
										<c:when test="${pelicula.estatus == 'Activa'}">
											<span class="label label-success">ACTIVA</span>
										</c:when>
										<c:otherwise>
											<span class="label label-danger">INACTIVA</span>
										</c:otherwise>
									</c:choose>
									
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>