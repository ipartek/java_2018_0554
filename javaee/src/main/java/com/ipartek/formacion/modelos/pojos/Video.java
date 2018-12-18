package com.ipartek.formacion.modelos.pojos;

public class Video {
	private Long id;
	private String titulo;
	private String url;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if(titulo==null || titulo.trim().length()==0) {
			titulo="¡LA NUEVA DRIFTBOARD DE FORTNITE! - TheGrefg";
		}
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", titulo=" + titulo + ", url=" + url + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		if(url==null || url.trim().length()==0) {
			url="https://www.youtube.com/watch?v=NMkDvINuxyY";
		}
		this.url = url;
	}
	public Video(Long id, String titulo, String url) {
		super();
		setId(id);
		setTitulo(titulo);
		setUrl(url);
	}
	public Video() {
		
	}
}
