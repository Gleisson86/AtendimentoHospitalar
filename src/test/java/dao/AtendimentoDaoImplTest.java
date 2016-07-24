package dao;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.annotation.Resource;

import model.Atendimento;
import model.Hospital;
import model.Medico;
import model.Paciente;
import model.Sintoma;

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
@ContextConfiguration(classes = { ApplicationConfig.class })
public class AtendimentoDaoImplTest {

	@Resource
	private HospitalDao hospitalDao;

	@Resource
	private MedicoDao medicoDao;

	@Resource
	private PacienteDao pacienteDao;

	@Resource
	private AtendimentoDao atendimentoDao;

	@Test
	@Transactional
	@Commit
	//Inclusão de atendimentos em horários distintos
	public void test() {
		Medico medico = preencherMedico();
		medico = medicoDao.incluir(medico);

		Paciente paciente = preencherPaciente();
		paciente = pacienteDao.incluir(paciente);

		Hospital hospital = preencherHospital();
		hospital = hospitalDao.incluir(hospital);

		Atendimento atend = preencherAtendimento(hospital, medico, paciente);
		atendimentoDao.incluir(atend);
		
		Atendimento atend1 = preencherAtendimento(hospital, medico, paciente);
		Calendar calendar = new GregorianCalendar(2016, 6, 25, 21, 40);
		atend1.setHorario(calendar.getTime());
		atendimentoDao.incluir(atend1);
	}

	@Test
	@Transactional
	@Commit
	//Trigger unicidade_horario_medico impede a inclusão do atendimento em horário já existente fazendo com que o teste falhe
	//Devido ao erro ser no commit da transação não é possível recuperá-lo nesse método
	public void test1() {
		Medico medico = medicoDao.listarTodos().get(0);
		
		Paciente paciente = pacienteDao.listarTodos().get(0);
		
		Hospital hospital = hospitalDao.listarTodos().get(0);

	
		Atendimento atend = preencherAtendimento(hospital, medico, paciente);
		atendimentoDao.incluir(atend);
	}

	private Medico preencherMedico() {
		Medico medico = new Medico();

		medico.setCrm(26860);
		medico.setEspecialidade("ALERGIA E IMUNOLOGIA");
		medico.getPessoaFisica().setNome("ANA CRISTINA DE REZENDE CASTANHEIRA");
		medico.getPessoaFisica().setCpf("644.184.513-07");
		Calendar calendar = new GregorianCalendar(1970, 1, 28);
		medico.getPessoaFisica().setDataNascimento(calendar.getTime());

		return medico;
	}

	private Paciente preencherPaciente() {
		Paciente paciente = new Paciente();

		paciente.getPessoaFisica().setNome("PHILIPPE");
		paciente.getPessoaFisica().setCpf("047.452.601-13");
		Calendar calendar = new GregorianCalendar(1994, 1, 28);
		paciente.getPessoaFisica().setDataNascimento(calendar.getTime());
		paciente.setAltura(1.74);
		paciente.setPeso(70.0);
		return paciente;
	}

	private Hospital preencherHospital() {
		Hospital hospital = new Hospital();

		hospital.getPessoaJuridica().setNome("HOSPITAL VILA DA SERRA");
		hospital.getPessoaJuridica().setCnpj("98.181.633/0001-48");
		return hospital;
	}

	private Atendimento preencherAtendimento(Hospital hospital,
			Medico medico, Paciente paciente) {
		
		Sintoma sintoma = new Sintoma();
		sintoma.setNome("FEBRE");
		sintoma.setLocal("CABECA");
		sintoma.setIntensidade(3);

		Atendimento atend = new Atendimento();
		Calendar calendar = new GregorianCalendar(2016, 6, 25, 19, 40);
		atend.setHorario(calendar.getTime());
		atend.setHospital(hospital);
		atend.setMedico(medico);
		atend.setPaciente(paciente);
		
		sintoma.setAtendimento(atend);
		atend.getSintomas().add(sintoma);
		return atend;
	}
}