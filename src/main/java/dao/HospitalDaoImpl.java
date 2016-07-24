package dao;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import model.Hospital;

import org.springframework.stereotype.Repository;

@Repository( "hospitalDao" )
class HospitalDaoImpl extends EntidadeDaoImpl<Hospital> implements HospitalDao {


	@Override
	public void limparAtendimentos(Long idHospital) {
		StoredProcedureQuery storedProcedure = getEntityManager().createStoredProcedureQuery("limpar_atend_hosp");
		storedProcedure.registerStoredProcedureParameter("id_hospital", Long.class, ParameterMode.IN);
		storedProcedure.setParameter("id_hospital", idHospital);
		storedProcedure.execute();
	}
}
