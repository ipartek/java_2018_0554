package com.ipartek.formacion.modelo.pojos;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Pagina {
	
	
	
	// Atributos
	
		private String autor;
		private String texto;
	
	// Constructores
	
		public Pagina() {
			super();
			this.autor = "Maria";
			this.texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ultricies et mauris laoreet elementum. Fusce imperdiet placerat mauris ac posuere. Phasellus id mattis est, et mollis risus. Donec a nulla sed dui tristique vehicula. Fusce at elementum massa, non pulvinar mauris. Aenean ultricies libero turpis, ut ultrices sapien iaculis vel. Curabitur euismod fermentum nibh, a blandit quam lacinia eget. Proin nisl ipsum, vulputate sed neque non, condimentum sagittis tortor. Morbi vitae maximus augue, nec elementum libero. Cras eget lobortis lorem, vehicula cursus enim. Cras magna velit, finibus id diam tempus, cursus pulvinar risus. Phasellus mattis metus non justo mattis rhoncus.\r\n" + 
					"\r\n" + 
					"Ut non ullamcorper quam. Fusce viverra aliquet risus ornare dapibus. Phasellus in nisi vitae quam accumsan posuere ut vitae eros. Aenean gravida vehicula quam, in posuere libero commodo id. Donec convallis vestibulum nunc, non hendrerit tellus condimentum gravida. Vestibulum egestas fermentum justo, finibus luctus augue posuere vitae. Duis scelerisque mauris et fringilla auctor. In sodales sapien sed risus consequat, ut dignissim risus pretium. Suspendisse quis eros tristique, scelerisque diam ut, pulvinar dolor. Curabitur sed sagittis magna.";
		}
		
		
		public Pagina(String autor, String texto) {
			this();
			setAutor(autor);
			setTexto(texto);
		}

		
	// Getters y Setters

		public String getAutor() {
			return autor;
		}


		public void setAutor(String autor) {
			this.autor = autor;
		}


		public String getTexto() {
			return texto;
		}


		public void setTexto(String texto) {
			this.texto = texto;
		}

		
	// Otros metodos => toString
		
		@Override
		public String toString() {
			return "Pagina [autor=" + autor + ", texto=" + texto + "]";
		}
		
}
