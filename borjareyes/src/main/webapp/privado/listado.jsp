<%@ include file="../includes/header.jsp" %>   
<%@ include file="../includes/navbar.jsp" %>  
<%@ include file="../includes/mensajes.jsp" %> 
<main>
	<ul>
		<c:forEach items="${perros}" var = "p">
        	<li> ${p.nombre }   ${p.chip}   <a href="mostrarperro?chip=${p.chip}">ver detalles</a></li> 
    	</c:forEach>
	</ul>
</main>
<%@ include file="../includes/footer.jsp" %>  