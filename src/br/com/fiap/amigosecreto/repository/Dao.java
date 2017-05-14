package br.com.fiap.amigosecreto.repository;

import java.util.List;

public interface Dao<T> {
	void adicionar(T entidade);
	void adicionar(List<T> entidades);
	 List<T> listar();
	 T buscar(int id); 
}
