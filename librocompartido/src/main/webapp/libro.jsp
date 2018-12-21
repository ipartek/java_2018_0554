

<h1>LIBRO COMPARTIDO</h1>

<p>LOGIN</p>

<p>${pagina.autor}</p>
<p>${pagina.texto}</p>

<p>${paginaactual+1}/${paginastotales}</p>


<span><a href="#">Anterior</a></span>
<span><a href="paginas?actual=${paginaactual+1}">Siguiente</a></span>


<form>
<label for=pagina>Ir a</label>
<input type="text" name="pagina" >
</form>