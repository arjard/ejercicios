<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Peliculas</title>
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../helpers/header.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">
    
    <c:if test="${mensaje!=null}">
    
    	<div class="alert alert-success" role="alert">${mensaje}</div>

	</c:if>

      <h3>Listado de Peliculas</h3>
      
      <a href="${urlRoot}create" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Titulo</th>
                <th>Genero</th>
                <th>Clasificacion</th>
                <th>Duracion</th>
                <th>Fecha Estreno</th>
                <th>Estatus</th>
                <th>Opciones</th>
            </tr>
            
            <c:forEach items="${peliculas}" var="pelicula">
            	 <tr>
	                <td>${pelicula.titulo}</td>
	                <td>${pelicula.genero}</td>
	                <td>${pelicula.clasificacion}</td>
	                <td>${pelicula.duracion}</td>
	                <td>${pelicula.fechaEstreno}</td>
	                
	                <c:choose>
	                	<c:when test="${pelicula.estatus == 'Activa'}">
	                		<td><span class="label label-success">${pelicula.estatus}</span></td>
	                	</c:when>
	                	<c:otherwise>
	                		<td><span class="label label-danger">${pelicula.estatus}</span></td>
	                	</c:otherwise>
	                </c:choose>

	                <td>
	                    <a href="#" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
	                    <a href="#" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
	                </td>
	            </tr>
            </c:forEach>

        </table>
      </div>
          
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../helpers/footer.jsp"></jsp:include>

    </div> <!-- /container -->

  </body>
</html>
