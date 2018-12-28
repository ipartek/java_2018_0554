<%@include file="/includes/navbar.jsp"%>
<main role="main" class="container">
<div class="jumbotron">
	<%@include file="/includes/mensajes.jsp"%>
	<form action="privado/insertarPerro" method="post">
	
		<h1>Añadir nuevo perro</h1>
		<div class="form-group">
			<label for="nPerro"> Introduce el nombre (Campo obligatorio)
			<input type="text" id="nPerro" name="nPerro" class="form-control" value="${nPerro}" required/>
			</label>
		</div>
		<div class="form-group">
			<label for="anios">Introduce los años que tiene
			<input type="number" id="anios" name="anios" class="form-control" value="${anios}"/>
			</label>
		</div>
		<div class="form-group">
			<label for="raza">Introduce la raza si la sabes (Campo obligatorio)
			<input type="text" id="raza" name="raza" class="form-control" required value="${raza}"/>
			</label>
		</div>
		<div class="form-group">
			<label for="peso">Introduce el peso 
			<input type="number" id="peso" name="peso" class="form-control" value="${peso}" />
			</label>
		</div>
		<div class="form-group">
			<label for="apadrinado">¿El perro está apadrinado?
				<select class="custom-select" id="apadrinado" name="apadrinado" ">
					<option value="Si" ${(apadrinado=="Si")?"selected" : "" }>Si</option>
    				<option value="No" ${(apadrinado=="No")?"selected" : "" }>No</option>
				</select>
			</label>
		</div>
		<h2>Ahora introduce los datos del chip(Campos obligatorios)</h2>
		<div class="form-group">
			<label for="num_identifiacion">Número de identificación
			<input type="text" id="num_identifiacion" name="num_identifiacion" class="form-control" placeholder="DD-DDDD-AAAA" value="${num_identifiacion}" required/>
			</label>
		</div>
		<div class="form-group">
			<label for="latitud">Latitud
			<input type="number" id="latitud" name="latitud" class="form-control" value="${latitud}" required/>
			</label>
		</div>
		<div class="form-group">
			<label for="longitud">Longitud
			<input type="number" id="longitud" name="longitud" class="form-control" value="${longitud}" required />
			</label>
		</div>
		
		
		

		<button type="submit" class="btn btn-primary">Insertar</button>
	</form>
</div>
</main>
<%@include file="/includes/footer.jsp"%>

