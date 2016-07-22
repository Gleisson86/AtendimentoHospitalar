package main.java.dao;

import java.util.List;

import main.java.model.Entidade;

public interface EntidadeDao<E extends Entidade<E>> {

	E obterPorId(Long id);
	List<E> listar(int offset, int limit, String ordem, String restricoes, Object... parametros);
	
	E incluir(E entidade);
	E alterar(E entidade);
	E remover(E entidade);
}
