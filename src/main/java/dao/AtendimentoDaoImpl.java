package dao;

import model.Atendimento;

abstract class AtendimentoDaoImpl<E extends Atendimento<E>> extends EntidadeDaoImpl<E> implements AtendimentoDao<E> {

}
