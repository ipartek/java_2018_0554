package com.ipartek.formacion.modelo.pojos;

public class Coche {

		private long id;
		private String marca;
		private String modelo;
		private String color;
		private String foto;
		
		public Coche(){
			super();
			this.id=-1;
			this.marca ="";
			this.modelo ="";
			this.color="";
			this.foto="";
		}
		
		
		
		
		
		public Coche(long id, String marca, String modelo, String color, String foto) {
			super();
			setId(id);
			setMarca(marca);
			setModelo(modelo);
			setColor(color);
			setFoto(foto);
		}





		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getFoto() {
			return foto;
		}
		public void setFoto(String foto) {
			this.foto = foto;
		}		
		
		@Override
		public String toString() {
			return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", foto=" + foto
					+ "]";
		}
		
		
}
