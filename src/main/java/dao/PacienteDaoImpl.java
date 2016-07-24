package dao;

import org.springframework.stereotype.Repository;

import model.Paciente;

@Repository( "pacienteDao" )
class PacienteDaoImpl extends EntidadeDaoImpl<Paciente> implements PacienteDao {
	
}
