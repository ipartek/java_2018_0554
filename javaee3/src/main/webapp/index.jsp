<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>
  
  <p>Idioma cookie ${cookie.cIdioma.value}</p>
 <form class="form-signin" action="login" method="post">
      <h1 class="h3 mb-3 font-weight-normal">Regístrate</h1>
      <label for="inputEmail" class="sr-only">Email</label>
      <input type="email" name="email" id="inputEmail" class="form-control" value="maria@gmail.com" placeholder="Email" required autofocus>
      <label for="inputPassword" class="sr-only">Contraseña</label>
      <input type="password" name="pass" id="inputPassword" class="form-control" value="12345678" placeholder="Contraseña" required>
      <!-- <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div> -->
      <label for="inputPassword" class="sr-only">Selecciona un idioma</label>
      <select name="idioma" class="form-control">
      	<option value="eu_ES">Euskera</option>
      	<option value="es_ES">Castellano</option>
      </select>
      <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="login.boton"/></button>
      <p class="error">${mensaje}</p>
    </form>