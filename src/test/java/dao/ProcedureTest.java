package dao;

import javax.annotation.Resource;

import model.Hospital;

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
public class ProcedureTest  {

	@Resource
	private HospitalDao hospitalDao;

	@Test
	@Transactional
	@Commit
	public void test1() {
		Hospital hospital = hospitalDao.listarTodos().get(0);
		hospitalDao.limparAtendimentos(hospital.getId());
	}
	
	@Test
	@Transactional
	@Commit
	public void test2() {
		hospitalDao.limparBancoDados();
	}
	
}
