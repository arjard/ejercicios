<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Detalles de la pelicula</title>

		<spring:url value="/resources" var="urlResources"></spring:url>

	</head>

	<body>

		<!-- Fixed navbar -->
		<jsp:include page="helpers/header.jsp"></jsp:include>

		<div class="container theme-showcase" role="main">

			<!-- Marketing messaging -->
			<div class="container marketing">

				<div class="page-header">
					<h2>${pelicula.titulo}</h2>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<p class="text-center">
							<img class="img-rounded" src="${urlResources}/images/${pelicula.imagen}" alt="Generic placeholder image" width="155" height="220">            
						</p>
					</div>
					<div class="col-sm-9">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">DETALLES</h3>
							</div>
							<div class="panel-body">                           
								<p>
									Título Original : ${pelicula.titulo} <br>
									Actores : ${pelicula.detalle.actores} <br>
									Director: ${pelicula.detalle.director}<br>                  
									Clasificación: ${pelicula.clasificacion} <br>
									Duración: ${pelicula.duracion} minutos <br>
									Género: ${pelicula.genero} <br>                  
									Fecha Estreno: ${pelicula.fechaEstreno}                  
								</p> 

							</div>
						</div>                          
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><span class="label label-success">20-05-2017</span></h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>                  
									<th>Hora</th>
									<th>Sala</th>                                  
									<th>Precio</th>                                  
								</tr>
							</thead>
							<tbody>             
								<tr>                 
									<td>16:00</td>
									<td>Sala 1</td>  
									<td>$10</td>  
								</tr>              
								<tr>                 
									<td>18:00</td>
									<td>Sala 1</td> 
									<td>$10</td>  
								</tr>              
								<tr>                 
									<td>20:00</td>
									<td>Sala 1</td>                        
									<td>$10</td>  
								</tr>              
								<tr>                
									<td>14:00</td>
									<td>Sala 1</td>                       
									<td>$10</td>  
								</tr>              
								<tr>               
									<td>16:00</td>
									<td>Sala 1</td> 
									<td>$10</td>  
								</tr>                             
								<tr>                  
									<td>20:00</td>
									<td>Sala 1</td> 
									<td>$10</td>  
								</tr>              
								<tr>                 
									<td>22:00</td>
									<td>Sala 1</td>  
									<td>$10</td>  
								</tr>              
							</tbody>           
						</table>
					</div>
				</div>


				<div class="row">
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">Trailer</h3>
							</div>
							<div class="panel-body">
								<iframe width="560" height="315" src="${fn:replace(pelicula.detalle.trailer,'watch?v=','embed/')}" 
								frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
								</iframe>
							</div>
						</div>           
					</div> 
					<div class="col-sm-5">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">SINOPSIS</h3>
							</div>
							<div class="panel-body">
								<p>${pelicula.detalle.sinopsis}</p>
							</div>
						</div>                          
					</div>
				</div>

			</div><!-- /.container -->

			<hr class="featurette-divider">

			<!-- FOOTER -->
			<jsp:include page="helpers/footer.jsp"></jsp:include>

		</div> <!-- /container -->

	</body>
</html>
