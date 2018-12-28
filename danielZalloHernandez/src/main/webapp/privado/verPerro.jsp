<%@include file="/includes/navbar.jsp"%>
<main role="main" class="container">


<div class="jumbotron">

	<h1>Nombre del perro seleccionado: ${perro.nombre}</h1>
	<p><span class="font-weight-bold">Raza:</span> ${perro.raza} </p>
	<p><span class="font-weight-bold">Edad:</span> ${perro.edad} años</p>
	<p><span class="font-weight-bold"> Peso:</span> ${perro.peso} kg </p>
	<p><span class="font-weight-bold"> Apadrinado:</span> ${perro.apadrinado} </p>
	<p class="font-weight-bold">Chip</p>
	<ul>
		<li><span class="font-weight-bold">Número identificación:</span> ${perro.chipAsignado.num_identifiacion} </li>
		<li><span class="font-weight-bold">Latitud:</span> ${perro.chipAsignado.latitud} </li>
		<li><span class="font-weight-bold">Longitud:</span> ${perro.chipAsignado.longitud}</li>
	</ul>

	
</div>
</main>
<%@include file="/includes/footer.jsp"%>