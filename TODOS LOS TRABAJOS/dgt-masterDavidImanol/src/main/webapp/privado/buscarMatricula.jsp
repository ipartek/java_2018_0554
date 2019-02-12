<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/cabecera.jsp"  %>
 <main role="main" class="container mt-3">	

<div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong> ${mensaje }</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>	

<form action="privado/buscar" method="post">		
	<div class="form-group">
	<label for="buscar" class="sr-only">Buscar Matricula</label>
	<input type="text" name="buscar"  class="form-control" autofocus value="${matricula!=null ? matricula : ''}" placeholder="3548MKZ">			    
	</div>	
	
	<div  class="form-group" class="sr-only">								
	<button type="submit" class="btn btn-primary btn-block">BUSCAR</button>
	</div>	
	
</form>

	
</main>				
<%@ include file="../includes/footer.jsp"  %>