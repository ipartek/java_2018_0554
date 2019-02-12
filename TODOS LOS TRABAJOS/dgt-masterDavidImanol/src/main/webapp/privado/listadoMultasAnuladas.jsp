<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/cabecera.jsp"  %>
 <main role="main" class="container-fluid ">


 <c:if test = "${mensaje!=null}">
<div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong> ${mensaje }</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>	

<h5>Multas Anuladas</h5>

<c:forEach items="${multas}" var="m">			
<!-- Modal -->
	<div class="modal fade" id="anular${m.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Atención</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					¿ Estas serguro que deseas activar de nuevo la multa ?
					<ul class="list-unstyled mt-3 mb-4">			         	
					<li>Fecha: ${m.fecha}</li>
					<li>Matricula: ${m.coche.matricula}</li>	
					<li>Importe: ${m.importe} €</li>
					<li>Concepto: ${m.concepto}</li>
							     
					</ul>			   
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
					<a href="privado/multa?operacion=3&id=${m.id}" class="btn btn-danger">ACTIVAR</a>
					<!-- &id_agente=${agente_logeado.id}&id_coche=${id.coche} -->
				</div>
				
				
			</div>
		</div>
	</div>
</c:forEach>
	    
 <div class="accordion" id="accordionExample">	
<table id="example" class="table tablaOrdenable" style="width:100%"> 
        <thead>
            <tr>
                <th>Fecha</th> 
                <th>Matricula</th>           
                <th>Hora</th>
                <th>Importe</th>
                <th>Concepto</th>
                <th>Modelo</th>
                <th>Kilometro</th>  
                <th>Activar</th>                            
            </tr>
        </thead>
        <tbody>
	         <c:forEach items="${multas}" var="m">	        	            
	            <tr>
	               	<td><fmt:formatDate pattern = "yyyy/MM/dd"  value = "${m.fecha}" /></td>				     
			     	<td>${m.coche.matricula}</td>		     		
				    <td><fmt:formatDate pattern = "HH:mm"  value = "${m.hora}" /></td>
			     	<td >${m.importe}</td>	
				   	<td>${m.concepto}</td>               		
					<td>${m.coche.modelo}</td> 
					<td>${m.coche.km}</td>
					<td>
			     		<button type="button" class="btn btn-outline-danger btn-block" data-toggle="modal" data-target="#anular${m.id}" >
							Activar
						</button>
				   	</td>  				             
	            </tr>	                                                   
	        </c:forEach>                  
        </tbody>      
            
    </table>   
 </div>
</main>				
<%@ include file="../includes/footer.jsp"  %>