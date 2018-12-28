<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>


<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">CHIP</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">EDAD</th>
      <th scope="col">RAZA</th>
       <th scope="col">APADRINADO</th>
      <th scope="col">LATITUD</th>
       <th scope="col">LONGITUD</th>
    </tr>
  </thead>
  <tbody>
  

  <tr>
      <th scope="row">${perro.chip } </th>
      <td>${perro.nombre }</td>
      <td>${perro.edad }</td>
      <td>${perro.raza }</td>
      <td>${perro.apadrinado }</td>
      <td>${perro.longitud }</td>
      <td>${perro.latitud }</td>
    </tr>

  </tbody>
</table>