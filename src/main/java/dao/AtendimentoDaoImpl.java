package dao;

import org.springframework.stereotype.Repository;

import model.Atendimento;

@Repository("atendimentoDao")
class AtendimentoDaoImpl extends EntidadeDaoImpl<Atendimento> implements AtendimentoDao {

}
