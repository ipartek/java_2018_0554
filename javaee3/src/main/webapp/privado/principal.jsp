<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
 <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
	<link 	href="https://getbootstrap.com/docs/4.1/examples/cover/cover.css"	rel="stylesheet">
	
</head>
<body class="text-center">

<%@page import="com.ipartek.formacion.pojo.Video"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Video> videos = (ArrayList<Video>)request.getAttribute("videos"); %>

 <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
	 <main role="main" class="inner cover">
	<h1 class="cover-heading">Bienvenida/o ${usuario.nombre}</h1>
	
	<ol>
	<% for(Video v : videos){ %>
		<li>
			<ul class="list-unstyled">
				<li><%=v.getNombre()%></li>
					<li ><iframe width="150" 
							        height="150" 
							        src="https://www.youtube.com/embed/<%=v.getUrl()%>" 
							        frameborder="0" 
							        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
							        allowfullscreen></iframe></li>
						
						</ul>			
					</li>
		<%} %>		
	</ol>
	
	<a href="logout" class="btn btn-lg btn-secondary">Cerrar sesión</a>
	</main>
</div>	
</body>
</html>



