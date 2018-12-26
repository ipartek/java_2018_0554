
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<main class="container section">
  <section class="row">
    <div class="col-md-12">
    <h2>Autor: ${pagina.autor}</h2>
      <p>
		${pagina.texto}
      </p>
    </div><!-- /col-md-12 -->
    <ul class="pagination">
    
    <c:if test = "${paginaactual !=0}">
   		</span>
   		<li class="page-item ">
      		<a href="paginas?actual=${paginaactual-1}" class="page-link">Anterior</a>
    	</li>
	</c:if>
	<li  class="page-link ">${paginaactual+1}/${paginastotales}<li>
    <c:choose> 
	  <c:when test="${paginaactual+1==paginastotales}"> 
	  </c:when>
	  <c:otherwise>
		  <li class="page-item">
	      <a href="paginas?actual=${paginaactual+1}" class="page-link">Siguiente</a>
	    </li>
	  </c:otherwise>
	</c:choose>
	<li>
	<form method="post" action="paginas" class="form-inline">
	<label class="sr-only" for=pagina>Ir a</label>
	<input type="text" name="pagina" id="pagina" class="form-control mb-2 mr-sm-2 mb-sm-0" >
	<button type="submit" class="btn btn-primary">Ir a página</button>
	<span style="color:red">${error }</span>
	</form>
	</li>
	
	
  </ul>
  
</section><!-- /row -->
</main><!-- /container section -->
 





<%@include file="includes/header.jsp" %>