package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.List;

public interface CrudAble<Pojo> {
	public List<Pojo> getAll();
	public Pojo getById(Long id);
	public void insert(Pojo pojo);
	public void update(Pojo pojo);
	public void delete(Pojo pojo);
}
