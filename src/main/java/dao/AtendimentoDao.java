package dao;

import java.math.BigDecimal;

import model.Atendimento;

public interface AtendimentoDao extends EntidadeDao<Atendimento> {

	String obterSintomaMaiorFrequencia();
	BigDecimal obterNumeroAtendimentosPorHospital(Long idHospital);
}
