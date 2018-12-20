
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Videos</title>

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="https://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="#">Action</a>
              <a class="dropdown-item" href="#">Another action</a>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>

    <main role="main" class="container">

      <div class="starter-template">
      
      <div class="container">
        <h1>Listado Videos</h1>
        <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Video</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${recuestScope.videos.id}</td>
        <td>${recuestScope.videos.nombre}</td>
        <td>${recuestScope.videos.url}</td>
      </tr>
      
    </tbody>
  </table>
  </div>

    </main><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
  </body>
</html>





<%-- <h1>Listado Videos</h1>

<%
	ArrayList<Video> videos = (ArrayList<Video>)request.getAttribute("videos");
	String busqueda = (String)request.getAttribute("busqueda");
%>

<% 
	if ( busqueda != null ){
		%>
			<p>Resultado para la busqueda: <b><%=busqueda%></b></p>
		<% 
	}else{
		busqueda = "";
	}
%>

<form action="videos" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>


<%
	if ( videos.isEmpty() ) {
%>
	<p style="color:red;"> No existen Videos todavia!!!</p>
<%
	} // if
%>

<ol>
	<%
		for( Video video: videos){
			%>
					<li>
							<%=video.getNombre()%>
							<iframe width="150" 
							        height="150" 
							        src="https://www.youtube.com/embed/<%=video.getUrl()%>" 
							        frameborder="0" 
							        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
							        allowfullscreen></iframe>
						<a href="carrito?id=<%=video.getId()%>">Añadir al Carrito</a>
					</li>
			<%	
		}	
	%>
</ol>
 --%>