package main.java.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.model.Entidade;

public class EntidadeDaoImpl<E extends Entidade<E>> implements EntidadeDao<E> {

	protected Class<E> entidadeClass;

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

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	@PersistenceContext(unitName = "mainPersistenceUnit")
	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public E obterPorId(Long id) {
		return getEntityManager().find(entidadeClass, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> listar(int offset, int limit, String ordem,
			String restricoes, Object... parametros) {
		Query query = getEntityManager().createQuery("from "+entidadeClass.getSimpleName());
		return query.getResultList();
	}

	@Override
	public E incluir(E entidade) {
		getEntityManager().persist(entidade);
		return entidade;
	}

	@Override
	public E alterar(E entidade) {
		return getEntityManager().merge(entidade);
	}

	@Override
	public E remover(E entidade) {
		getEntityManager().flush();
		getEntityManager().remove(obterPorId(entidade.getId()));
		return entidade;
	}

}
