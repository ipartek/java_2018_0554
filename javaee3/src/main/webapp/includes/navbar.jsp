 <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
   <a class="navbar-brand" href="#">APP VIDEOS</a>
   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
     <span class="navbar-toggler-icon"></span>
   </button>
   <div class="collapse navbar-collapse" id="navbarCollapse">
     <ul class="navbar-nav mr-auto">
       <li class="nav-item active">
         <a class="nav-link" href="${pageContext.request.contextPath}/privado/videos">Videos</a>
       </li>
       <li class="nav-item active">
         <a class="nav-link" href="${pageContext.request.contextPath}/privado/perros">Perros</a>
       </li>
     </ul>
   </div>
   <span>${usuario.email}</span>
   <a href="/logout">logout</a>
 </nav>