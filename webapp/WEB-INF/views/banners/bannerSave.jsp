<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Creacion de imagenes del Banner</title>

<spring:url value="/banner/save" var="urlBanners" ></spring:url>

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../helpers/header.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos de la imagen</span>
		</h3>


		<spring:hasBindErrors name="banner">
			<div class="alert alert-danger" role="alert">
				Hubieron los siguientes errores
				<ul>
					<c:forEach items="${errors.allErrors}" var="error">
						<li>${error}</li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form action="${urlBanners}" method="post" enctype="multipart/form-data" modelAttribute="banner">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="titulo">Titulo</label> 
						<form:input type="text" class="form-control" path="titulo" name="titulo" id="titulo" required="required" />
					</div>
				</div>


				<div class="col-sm-3">
					<div class="form-group">
						<label for="imagen">Imagen</label> 
						<input type="file" id="archivo" name="archivo"  required="required"/>
						<p class="help-block">Tamaño recomendado: 1140 x 250</p>
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="estatus">Estatus</label> 
						<form:select path="estatus" id="estatus" name="estatus" class="form-control">
							<form:option value="Activo">Activo</form:option>
							<form:option value="Inactivo">Inactivo</form:option>
						</form:select>
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


</body>
</html>
