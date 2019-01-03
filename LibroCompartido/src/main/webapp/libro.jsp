<h1>LIBRO COMPARTIDO</h1>

<h2>Autor</h2><p>${pagina.autor}</p>
<h2>texto</h2><p>${pagina.texto}</p>
Pagina ${paginaActual + 1} / ${paginas.size()}

Ir a la pagina <input type=""> <button>Ir</button><br>
<a href="pagina?pagina=${paginaActual-1}">Pagina Anterior</a>
<a href="pagina?pagina=${paginaActual+1}">Pagina Siguiente</a>