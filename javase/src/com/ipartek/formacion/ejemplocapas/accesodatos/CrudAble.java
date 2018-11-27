package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.List;

public interface CrudAble<Pojo> { // default existe a partir de Java 8
	public default List<Pojo> getAll() {
		throw new RuntimeException("No implementado");
	}
	public default Pojo getById(Long id) {
		throw new RuntimeException("No implementado");
	}
	public default void insert(Pojo pojo) {
		throw new RuntimeException("No implementado");
	}
	public default void update(Pojo pojo) {
		throw new RuntimeException("No implementado");
	}
	public default void delete(Long id) {
		throw new RuntimeException("No implementado");
	}
}
