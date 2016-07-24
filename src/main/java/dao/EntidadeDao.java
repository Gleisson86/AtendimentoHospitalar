package dao;

import java.util.List;

import model.Entidade;

public interface EntidadeDao<E extends Entidade<E>> {

	E obterPorId(Long id);
	List<E> listarTodos();
	
	E incluir(E entidade);
	E alterar(E entidade);
	E remover(E entidade);
	
	void limparBancoDados();
}
