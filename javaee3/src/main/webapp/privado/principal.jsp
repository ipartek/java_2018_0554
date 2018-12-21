<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>

  

    <main role="main" class="container">
      <div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">

       
			<ol class="list-group">
				<c:forEach items="${videos}" var="v">
					<span class="border border-primary"><li class="list-group p-3">${v.id} + ${v.nombre} +  src="https://www.youtube.com/embed/${v.url}" </li></span>
				</c:forEach>
			</ol>
       
      </div>
    </main>

  
<%@ include file="../includes/footer.jsp"  %>  