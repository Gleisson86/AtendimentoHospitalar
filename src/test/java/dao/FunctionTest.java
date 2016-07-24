package dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import javax.annotation.Resource;

import model.Hospital;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ ApplicationConfig.class })
public class FunctionTest  {

	@Resource
	private AtendimentoDao atendimentoDao;
	
	@Resource
	private HospitalDao hospitalDao;

	@Test
	public void test1() {
		String sintoma = atendimentoDao.obterSintomaMaiorFrequencia();
		assertEquals(sintoma, "FEBRE");
	}
	
	@Test
	public void test2() {
		Hospital hospital = hospitalDao.listarTodos().get(0);
		BigDecimal numAtendimentos = atendimentoDao.obterNumeroAtendimentosPorHospital(hospital.getId());
		assertEquals(numAtendimentos, BigDecimal.valueOf(2));
	}
	
}
