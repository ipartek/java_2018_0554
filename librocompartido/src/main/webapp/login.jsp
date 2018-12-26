    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

    <form  novalidate class="form-signin" method="post" action="login">
    	
    	<!-- 
      <img class="mb-4" src="img/logo.jpg" alt="" width="100" height="100">
      <h1 class="h3 mb-3 font-weight-normal">LOGIN BRUTAL</h1>
      -->
      
      <label for="mail" class="sr-only">Email</label>
      <input type="email" id="mail" name=mail class="form-control"  value="ima@gmail.com">
      
      <label for="pass" class="sr-only">ContraseÃ±a</label>
      <input type="password" id="pass" name="pass" class="form-control" value="Pa$$w0rd" >
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Acceder</button>
      
	<c:if test="${error != null }">
     <div class="alert alert-warning alert-dismissible fade show" role="alert">
 		${error}
	</div>
	</c:if>
    </form>
 
<%@include file="includes/header.jsp" %>