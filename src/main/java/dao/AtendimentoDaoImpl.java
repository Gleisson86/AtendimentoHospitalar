package dao;

import java.math.BigDecimal;

import javax.persistence.Query;

import model.Atendimento;

import org.springframework.stereotype.Repository;

@Repository("atendimentoDao")
class AtendimentoDaoImpl extends EntidadeDaoImpl<Atendimento> implements AtendimentoDao {

	@Override
	public String obterSintomaMaiorFrequencia() {
		Query query = getEntityManager().createNativeQuery("SELECT max_freq_sintoma FROM dual");
		String sintoma = (String) query.getSingleResult();
		return sintoma;
	}
	
	@Override
	public BigDecimal obterNumeroAtendimentosPorHospital(Long idHospital) {
		Query query = getEntityManager().createNativeQuery("SELECT n_atend_hospital(?) FROM dual");
		query.setParameter(1, idHospital);
		BigDecimal numAtend = (BigDecimal) query.getSingleResult();
		return numAtend;
	}
	
	
}
