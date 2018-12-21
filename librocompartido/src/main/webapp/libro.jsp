<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<h1>LIBRO COMPARTIDO</h1>

<p>LOGIN</p>

<p>${pagina.autor}</p>
<p>${pagina.texto}</p>

<p>${paginaactual+1}/${paginastotales}</p>

<c:if test = "${paginaactual !=0}">
   <span><a href="paginas?actual=${paginaactual-1}">Anterior</a></span>
</c:if>
<c:if test = "${paginaactual !=paginastotales}">
   <span><a href="paginas?actual=${paginaactual+1}">Siguiente</a></span>
</c:if>





<form>
<label for=pagina>Ir a</label>
<input type="text" name="pagina" >
</form>