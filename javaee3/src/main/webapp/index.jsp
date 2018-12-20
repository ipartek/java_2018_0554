<link href="css/estilos.css" rel="stylesheet" id="bootstrap-css">
<link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/java.js"></script>
<!------ Include the above in your HEAD tag ---------->
<div class="container">
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
        <form method="post" action="login" role="login">
          <img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="logo perrillos.com" />
          <input type="email" name="usuario" placeholder="Usuario" required class="form-control input-lg" />
          
          <input type="password" class="form-control input-lg" name="pass" id="password" placeholder="Contraseña" required="" />
          
          
          <div class="pwstrength_viewport_progress"></div>
          
          
          <button type="submit" name="Entrar" class="btn btn-lg btn-primary btn-block">Acceder</button>
          <div>
            <a href="#">Registrarse</a> o <a href="#">cambiar contraseña</a>
          </div>
          
        </form>
        
        <div class="form-links">
          ${error}
        </div>
      </section>  
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
  
  
</div>
