package dao;

import model.Hospital;

public interface HospitalDao extends EntidadeDao<Hospital> {

	void limparAtendimentos(Long idHospital);
}
