<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Creacion de Peliculas</title>

<spring:url value="/resources" var="urlResources"></spring:url>
<spring:url value="/peliculas/save" var="urlPeliculas"></spring:url>

<link href="${urlResources}/css/jquery.fileupload.css" rel="stylesheet">

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../helpers/header.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="page-header">
			<h3 class="blog-title">
				<span class="label label-success">Datos de la Pelicula</span>
			</h3>
		</div>

		<spring:hasBindErrors name="pelicula">
			<div class="alert alert-danger" role="alert">
				Hubieron los siguientes errores
				<ul>
					<c:forEach items="${errors.allErrors}" var="error">
						<li>${error}</li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form action="${urlPeliculas}" method="post"
			enctype="multipart/form-data" modelAttribute="pelicula">
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="titulo">Título</label>
						<form:input type="text" class="form-control" path="titulo"
							id="titulo" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="duracion">Duracion</label>
						<form:input type="text" class="form-control" path="duracion"
							id="duracion" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="clasificacion" class="control-label">Clasificacion</label>
						<form:select id="clasificacion" path="clasificacion"
							class="form-control">
							<form:option value="A">Clasificacion A</form:option>
							<form:option value="B">Clasificacion B</form:option>
							<form:option value="C">Clasificacion C</form:option>
						</form:select>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="genero" class="control-label">Genero</label>

						<form:select id="genero" path="genero" class="form-control"
							items="${generos}"></form:select>

					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="estatus" class="control-label">Estatus</label>
						<form:select id="genero" path="estatus" class="form-control">
							<form:option value="Activa">Activa</form:option>
							<form:option value="Inactiva">Inactiva</form:option>
						</form:select>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="fechaEstreno">Fecha Estreno</label>
						<form:input type="text" class="form-control" path="fechaEstreno"
							id="fechaEstreno" required="required" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<!--               <label for="imagen">Imagen</label> -->

						<span class="btn btn-success fileinput-button"> <i
							class="glyphicon glyphicon-plus"></i> <span>Añadir
								imagen...</span> <!-- The file input field used as target for the file upload widget -->
							<input id="fileupload" type="file" name="files[]" multiple>
						</span>

						<!--               <input type="file" id="archivoImagen" name="archivoImagen" required="required" /> -->
						<p class="help-block">Imagen de la pelicula</p>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
				<!-- The container for the uploaded files -->
						<div id="files" class="files"></div>
					</div>
				</div>
			</div>
			<!-- ///////////////////////////////// Detalles de la pelicula /////////////////////////////////////////// -->
			<div class="page-header">
				<h3 class="blog-title">
					<span class="label label-success">Detalles</span>
				</h3>
			</div>

			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="director">Director</label>
						<form:input type="text" class="form-control"
							path="detalle.director" id="director" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="actores">Actores</label>
						<form:input type="text" class="form-control"
							path="detalle.actores" id="actores" required="required" />
					</div>
				</div>

				<div class="col-sm-6">
					<div class="form-group">
						<label for="trailer">URL del Trailer (Youtube)</label>
						<form:input type="text" class="form-control"
							path="detalle.trailer" id="trailer"
							placeholder="URL completa del video de YOUTUBE"
							required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="sinopsis">Sinopsis</label>
						<form:textarea class="form-control" rows="5"
							path="detalle.sinopsis" id="sinopsis"></form:textarea>
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
	<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
	<script src="${urlResources}/js/vendor/jquery.ui.widget.js"></script>
	<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
	<script src="https://blueimp.github.io/JavaScript-Load-Image/js/load-image.all.min.js"></script> 
	<!-- The Canvas to Blob plugin is included for image resizing functionality -->
	<script src="https://blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
	<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
	<script src="${urlResources}/js/jquery.iframe-transport.js"></script>
	<!-- The basic File Upload plugin -->
	<script src="${urlResources}/js/jquery.fileupload.js"></script>
	<!-- The File Upload processing plugin -->
	<script src="${urlResources}/js/jquery.fileupload-process.js"></script>
	<!-- The File Upload image preview & resize plugin -->
	<script src="${urlResources}/js/jquery.fileupload-image.js"></script>

	<script>
		
		/*jslint unparam: true, regexp: true */
		/*global window, $ */
		$(function () {
		    'use strict';
		    
		    $("#fechaEstreno").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		    
		    // Change this to the location of your server-side upload handler:
		    var url = window.location.hostname === 'blueimp.github.io' ?
		                '//jquery-file-upload.appspot.com/' : 'server/php/',
		        uploadButton = $('<button/>')
		            .addClass('btn btn-primary')
		            .prop('disabled', true)
		            .text('Processing...')
		            .on('click', function () {
		                var $this = $(this),
		                    data = $this.data();
		                $this
		                    .off('click')
		                    .text('Abort')
		                    .on('click', function () {
		                        $this.remove();
		                        data.abort();
		                    });
		                data.submit().always(function () {
		                    $this.remove();
		                });
		            });
		    $('#fileupload').fileupload({
		        url: url,
		        dataType: 'json',
		        autoUpload: false,
		        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
		        maxFileSize: 999000,
		        // Enable image resizing, except for Android and Opera,
		        // which actually support image resizing, but fail to
		        // send Blob objects via XHR requests:
		        disableImageResize: /Android(?!.*Chrome)|Opera/
		            .test(window.navigator.userAgent),
		        previewMaxWidth: 200,
		        previewMaxHeight: 100,
		        previewCrop: true
		    }).on('fileuploadadd', function (e, data) {
		        data.context = $('<div/>').appendTo('#files');
		        $.each(data.files, function (index, file) {
		            var node = $('<p/>')
		                    .append($('<span/>').text(file.name));
		            if (!index) {
		                node
		                    .append('<br>')
// 		                    .append(uploadButton.clone(true).data(data));
		            }
		            node.appendTo(data.context);
		        });
		    }).on('fileuploadprocessalways', function (e, data) {
		        var index = data.index,
		            file = data.files[index],
		            node = $(data.context.children()[index]);
		        if (file.preview) {
		            node
		                .prepend('<br>')
		                .prepend(file.preview);
		        }
		        if (file.error) {
		            node
		                .append('<br>')
		                .append($('<span class="text-danger"/>').text(file.error));
		        }
		        if (index + 1 === data.files.length) {
		            data.context.find('button')
		                .text('Upload')
		                .prop('disabled', !!data.files.error);
		        }
		    }).on('fileuploadprogressall', function (e, data) {
		        var progress = parseInt(data.loaded / data.total * 100, 10);
		        $('#progress .progress-bar').css(
		            'width',
		            progress + '%'
		        );
		    }).on('fileuploaddone', function (e, data) {
		        $.each(data.result.files, function (index, file) {
		            if (file.url) {
		                var link = $('<a>')
		                    .attr('target', '_blank')
		                    .prop('href', file.url);
		                $(data.context.children()[index])
		                    .wrap(link);
		            } else if (file.error) {
		                var error = $('<span class="text-danger"/>').text(file.error);
		                $(data.context.children()[index])
		                    .append('<br>')
		                    .append(error);
		            }
		        });
		    }).on('fileuploadfail', function (e, data) {
		        $.each(data.files, function (index) {
		            var error = $('<span class="text-danger"/>').text('File upload failed.');
		            $(data.context.children()[index])
		                .append('<br>')
		                .append(error);
		        });
		    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		});
	</script>
</body>
</html>
