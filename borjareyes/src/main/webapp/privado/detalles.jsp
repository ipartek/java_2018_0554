<%@ include file="../includes/header.jsp" %>   
<%@ include file="../includes/navbar.jsp" %>  
<%@ include file="../includes/mensajes.jsp" %> 
<main>
<h1>resumen de ${perro.nombre}</h1>

<p>Chip: ${perro.chip}</p>
<p>Peso: ${perro.peso}</p>
<p>Edad: ${perro.edad}</p>
<p>Raza: ${perro.raza}</p>
<p><c:choose><c:when test="${perro.padrino==false}">NO APADRINADO</c:when><c:otherwise>APADRINADO</c:otherwise></c:choose></p>


</main>
<%@ include file="../includes/footer.jsp" %>  