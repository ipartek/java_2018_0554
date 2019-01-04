package com.ipartek.formacion.modelo.pojo;

public class Comentario {
private Long id;

private Usuario usuario;

private Video video;

private String texto;

private String fecha;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

public Video getVideo() {
	return video;
}

public void setVideo(Video video) {
	this.video = video;
}

public String getTexto() {
	return texto;
}

public void setTexto(String texto) {
	this.texto = texto;
}

public String getFecha() {
	return fecha;
}

public void setFecha(String fecha) {
	this.fecha = fecha;
}

public Comentario(Long id, Usuario usuario, Video video, String texto, String fecha) {
	this();
	setId(id);
	setUsuario(usuario);
	setVideo(video);
	setTexto(texto);
	setFecha(fecha);
}

public Comentario() {
	super();
	this.id=-1l;
	this.usuario=new Usuario();
	this.video=new Video();
	this.texto="";
	this.fecha="";
}

@Override
public String toString() {
	return "Comentario [id=" + id + ", usuario=" + usuario + ", video=" + video + ", texto=" + texto + ", fecha="
			+ fecha + "]";
}



}
