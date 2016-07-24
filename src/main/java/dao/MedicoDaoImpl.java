package dao;

import org.springframework.stereotype.Repository;

import model.Medico;

@Repository("medicoDao")
class MedicoDaoImpl extends EntidadeDaoImpl<Medico> implements MedicoDao {

}
