<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp" %>

<form action="formularionoticia" method="post">
	<fieldset>
		<legend>Noticia (${accion})</legend>
		
		<input type="hidden" name="accion" value="${accion}" />
		
		<input type="hidden" name="id" id="id" value="${noticia.id}" />

		<p>
			<label for="titulo">Título</label>
			<input type="text" name="titular" id="titular" value="${noticia.titular}" />
			<span class="error">${noticia.errorTitular}</span>
		</p>
		<p>
			<label for="fecha">Fecha</label>
			<input type="datetime-local" name="fecha" id="fecha" value="<fmt:formatDate pattern = "dd.MM.yy HH:mm:ss" value = "${noticia.fecha}" />" />
			<span class="error">${noticia.errorFecha}</span>
		</p>
		<p>
			<label for="autor">Autor</label>
			<input type="text" name="autor" id="autor" value="${noticia.autor}" />
			<span class="error">${noticia.errorAutor}</span>
		</p>
		<p>
			<label for="texto">Texto</label>
			<textarea name="texto" id="" cols="80" rows="10">${noticia.texto}</textarea>
			<span class="error">${noticia.errorTexto}</span>
		</p>
		<p>
			<button>Aceptar</button>
			<c:if test="${!noticia.correcto}">
				<span class="error">Hay errores en los datos</span>
			</c:if>
		</p>
	</fieldset>
</form>

<%@ include file="includes/pie.jsp" %>

