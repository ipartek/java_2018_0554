<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">

<style>
.banner{
background:url('css/wallpaper.jpg');}
input {cursor: pointer;} </style>

</head>
<body>



	<div class="pt-5"></div>
	<section class="banner bg-info text-white py-5" id="banner">
		<div class="container py-5">
			<div class="row">
				<div class="col-md-8">
					<div class="pt-5"></div>
					<h3></h3>
					<h3></h3>
					<div class="row pt-5"></div>
					<div class="input-group mb-3 pt-5">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">WSDL</span>
						</div>
						<input
							onclick="location.href = 'http://localhost:8080/wssoap/services/WSVehiculo?wsdl';"
							type="text" class="form-control" aria-label="Default"
							aria-describedby="inputGroup-sizing-default"
							value="http://localhost:8080/wssoap/services/WSVehiculo?wsdl"
							id="wsdlcopy">
						<button class="btn btn-warning" onclick="copiarText()">Copiar
							al portapapeles</button>

					</div>

				</div>

			</div>
		</div>
	</section>
<hr>
	<section class="aboutus py-5 " id="aboutus">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-12">
							<h3 class="text-primary">Lorem Ipsum</h3>
							<h4>Coming soon...</h4>
							<p>Work in progress...</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<h5>Low Cost</h5>
							<p>Low cost provides yur best for elit, sed do eiusmod tempe</p>
						</div>
						<div class="col-md-6">
							<h5>Good Marketing</h5>
							<p>Low cost provides yur best for elit, sed do eiusmod tempe</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<h5>Easy to Find</h5>
							<p>Low cost provides yur best for elit, sed do eiusmod tempe</p>
						</div>
						<div class="col-md-6">
							<h5>Reliable</h5>
							<p>Low cost provides yur best for elit, sed do eiusmod tempe</p>
						</div>
					</div>
				</div>


			</div>
		</div>
	</section>



	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script>
		function copiarText() {

			var copyText = document.getElementById("wsdlcopy");

			copyText.select();

			document.execCommand("copy");

			alert("Copiado con exito");
		}
	</script>
</body>
</html>