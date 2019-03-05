  </main>
  <footer class="mastfoot mt-auto">
    <div class="inner">
      <p>Ander Solana &#38; Daniel Zallo</p>
    </div>
  </footer>

<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous" ></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap4.min.js"></script>
	<script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
	<script src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap4.min.js"></script>
	
	
	
	
	<script>	
	$(document).ready(function() {
	    $('#tabla_multas').DataTable({
	    	 language: {
		 	        url: '//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json'		 	       	
		 	    },
		 	 "pageLength":25,
		 	"order": [[ 1, "desc" ]]
	    	
	    });
	} );
	</script>
	</div>
</body>
</html>

  