package dao;

import javax.annotation.Resource;

import model.Cidade;
import model.UF;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes={ ApplicationConfig.class })
public class CidadeDaoImplTest  {

	@Resource
	private CidadeDao cidadeDao;
	
	private Cidade cidade;
	
	@Before
	public void setUp() {
		cidade = new Cidade();
		cidade.setNome("Goiania");
		cidade.setUf(UF.GO);
	}

	@Test
	@Transactional
	@Commit
	public void test() {
		cidade = cidadeDao.incluir(cidade);
		
		cidade.setNome("Goianira");
		cidadeDao.alterar(cidade);
		
		for (Cidade c : cidadeDao.listarTodos()) {
			if (c.equals(cidade)) {
				cidadeDao.remover(cidade);
				return;
			}
		}	
//		
//		Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
//		Date date = calendar.getTime();
		//Cidade não foi incluída
		throw new RuntimeException();
	}
	
}
