
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <spring:url value="/resources" var="urlResources"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>
    
    <link href="${urlResources}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlResources}/css/theme.css" rel="stylesheet">
    
              <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlResources}/js/bootstrap.min.js"></script>     
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<spring:url value="/" var="urlRoot" />
    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${urlRoot}">My CineSite</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          	<li><a href="${urlRoot}peliculas/list">Peliculas</a></li>      
            <li><a href="#">Acerca</a></li>
            <li><a href="#">Login</a></li>            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
