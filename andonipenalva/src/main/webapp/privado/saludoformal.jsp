<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelos.pojos.Usuario, java.util.ArrayList"%>


<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/footer.jsp"%>

<main role="main" class="container w-50">
<form action="SaludoController" method="post" class="form-signin">
	<fieldset>
		<legend>Como te podemos saludar?</legend>

		<p>
			<label for="nombre">Nombre</label>
			
			<input type="text" name="nombre" id="nombre"  />
		</p>
		<p>
			<label for="apellidos">Apellidos</label>
			
			<input type="text" name="apellidos" id="apellidos"  />
		</p>
		<p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
		<%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %> 
		
				</p>
	</fieldset>
</form>
</main>