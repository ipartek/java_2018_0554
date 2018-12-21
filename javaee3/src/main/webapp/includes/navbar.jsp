 <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Fixed navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="privado/videos">Videos <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
          </li>
    <li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown">Welcome, User <b class="caret"></b></a>
		<ul class="dropdown-menu">
			<li><a href="/user/preferences"><i class="icon-cog"></i>
					Preferences</a></li>
			<li><a href="/help/support"><i class="icon-envelope"></i>
					Contact Support</a></li>
			<li class="divider"></li>
			<li><a href="/auth/logout"><i class="icon-off"></i> Logout</a></li>
		</ul></li>
        </ul>
        
      </div>
    </nav>