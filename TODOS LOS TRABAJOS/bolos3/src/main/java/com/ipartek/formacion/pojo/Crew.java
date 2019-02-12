package com.ipartek.formacion.pojo;

public class Crew {
	private Long id;
	private String foh;
	private String monitores;
	private String luces;

	public Crew() {

		super();
		this.id = -1L;
		this.foh = "";
		this.monitores = "";
		this.luces = "";

	}

	public Crew(Long id, String foh, String monitores, String luces) {
		this();
		setId(id);
		setFoh(foh);
		setMonitores(monitores);
		setLuces(luces);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoh() {
		return foh;
	}

	public void setFoh(String foh) {
		this.foh = foh;
	}

	public String getMonitores() {
		return monitores;
	}

	public void setMonitores(String monitores) {
		this.monitores = monitores;
	}

	public String getLuces() {
		return luces;
	}

	public void setLuces(String luces) {
		this.luces = luces;
	}

	@Override
	public String toString() {
		return "Crew [id=" + id + ", foh=" + foh + ", monitores=" + monitores + ", luces=" + luces + "]";
	}

}