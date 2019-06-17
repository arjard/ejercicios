<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="">
<title>Creacion de Horarios</title>

<spring:url value="/" var="urlRaiz"></spring:url>


<body>

	<!-- Fixed navbar -->
	<jsp:include page="../helpers/header.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos del Horario</span>
		</h3>

		<form:form action="${urlRaiz}horarios/save" modelAttribute="horario" method="post">
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="idPelicula" class="control-label">Pelicula</label> 
						<form:select id="idPelicula" path="idPelicula" items="${peliculas}" itemValue="id" itemLabel="titulo" name="idPelicula" class="form-control">
						</form:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="fecha">Fecha</label> 
						<form:input type="text" class="form-control" path="fecha" name="fecha" id="fecha" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="hora">Hora</label> <form:input type="text"
							class="form-control" name="hora" id="hora" path="hora"
							placeholder="Formato: HH:mm Ejemplo 21:30" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="sala" class="control-label">Sala</label> 
						<form:select id="sala" path="sala" name="sala" class="form-control">
							<form:option value="Premium">Sala Premium</form:option>
							<form:option value="Sala 1">Sala 1</form:option>
							<form:option value="Sala 2">Sala 2</form:option>
							<form:option value="Sala 3">Sala 3</form:option>
						</form:select>
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="precio">Precio</label> 
						<form:input type="text" class="form-control" name="precio" id="precio"
							path="precio" required="required" />
					</div>
				</div>

			</div>

			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="../helpers/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<script>
		$(function() {
			$("#fecha").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>