<%@ include file="../include/header.jsp"%>
<%@ include file="../include/navbar.jsp"%>
	


      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Sesión actual: ${sessionScope.usuario_logeado.email}</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group mr-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">Sesión</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">Cookies</button>
             <button type="button" class="btn btn-sm btn-outline-secondary">Información</button>
          </div> 
        </div>
      </div>

 			
  <div class="card-deck mb-3 text-center">

      <div class="card mb-3 shadow-sm">
        <div class="card-header">
          <h4 class="my-0 font-weight-normal">Cookies</h4>
        </div>
        <div class="card-body">
          <h1 class="card-title pricing-card-title h5">${sessionScope.usuario_logeado.email}</h1>
          <ul class="list-unstyled mt-3 mb-4">
          	<li>${cookie.cEmail.getValue()}</li>
          	<li>${cookie.cVisita.getValue()}</li> 
			<li>${cookie.cIdioma.getValue()}</li>			
          </ul>
        </div>
      </div>
      
       <div class="card mb-3 shadow-sm">
        <div class="card-header">
          <h4 class="my-0 font-weight-normal">Sesión</h4>
        </div>
        <div class="card-body">
        <h1 class="card-title pricing-card-title h5">${sessionScope.usuario_logeado.email}</h1>
          <ul class="list-unstyled mt-3 mb-4">
			<li>Navegador: ${sessionScope.navegador}</li> 
  			<li>IP: ${sessionScope.ip}</li>
  			
          </ul>
        </div>
      </div>
      
       <div class="card mb-3 shadow-sm">
        <div class="card-header">
          <h4 class="my-0 font-weight-normal">Datos de la aplicación</h4>
        </div>
        <div class="card-body">
        <h1 class="card-title pricing-card-title h5">${sessionScope.usuario_logeado.email}</h1>
          <ul class="list-unstyled mt-3 mb-4">
			<li class=" h6">Videos: ${contadorvideos}</li>
			<li class=" h6">Usuarios: ${contadorusuarios}</li>
          </ul>
        </div>
      </div>
      
 


  </div>



     

      <h2>Tabla de resultados</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>#</th>
              <th>Header</th>
              <th>Header</th>
              <th>Header</th>
              <th>Header</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1,001</td>
              <td>Lorem</td>
              <td>ipsum</td>
              <td>dolor</td>
              <td>sit</td>
            </tr>
            <tr>
              <td>1,001</td>
              <td>Lorem</td>
              <td>ipsum</td>
              <td>dolor</td>
              <td>sit</td>
            </tr>
          </tbody>
        </table>
      </div>

</main>

	
	
<%@ include file="../include/footer.jsp"%>
