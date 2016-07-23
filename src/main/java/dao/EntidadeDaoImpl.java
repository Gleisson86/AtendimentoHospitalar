package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Entidade;
import dao.EntidadeDao;

public class EntidadeDaoImpl<E extends Entidade<E>> implements EntidadeDao<E> {

	protected Class<E> entidadeClass;

	@PersistenceContext(unitName="AtendimentoHospitalar")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public EntidadeDaoImpl() {
		Class<?> clazz = getClass();
		while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
			clazz = clazz.getSuperclass();
		}
		try {
			ParameterizedType parameterizedType = (ParameterizedType) clazz
					.getGenericSuperclass();
			entidadeClass = (Class<E>) parameterizedType
					.getActualTypeArguments()[0];
		} catch (Exception e) {
			entidadeClass = null;
		}
	}

	@Override
	public E obterPorId(Long id) {
		return entityManager.find(entidadeClass, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> listarTodos() {
		Query query = entityManager.createQuery("from "+entidadeClass.getSimpleName());
		return query.getResultList();
	}

	@Override
	public E incluir(E entidade) {
		entityManager.persist(entidade);
		return entidade;
	}

	@Override
	public E alterar(E entidade) {
		return entityManager.merge(entidade);
	}

	@Override
	public E remover(E entidade) {
		entityManager.flush();
		entityManager.remove(obterPorId(entidade.getId()));
		return entidade;
	}

}
