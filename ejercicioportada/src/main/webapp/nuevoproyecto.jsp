<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo proyecto</title>
</head>
<body>
<h1>Nuevo proyecto</h1>

<form action="guardarproyecto">
	<fieldset>
		<legend>Nuevo proyecto</legend>
		<p>
			<label for="id">Id</label>
			<input type="number" name="id" id="id" />
		</p>
		<p>
			<label for="titulo">Título</label>
			<input name="titulo" id="titulo" />
		</p>
		<p>
			<label for="descripcion">Descripción</label>
			<textarea name="descripcion" id="descripcion" cols="80" rows="10"></textarea>
		</p>
		<p>
			<button>Guardar cambios</button>
		</p>
	</fieldset>
</form>

</body>
</html>