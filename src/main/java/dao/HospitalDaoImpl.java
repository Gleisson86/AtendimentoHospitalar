package dao;

import org.springframework.stereotype.Repository;

import model.Hospital;

@Repository( "hospitalDao" )
class HospitalDaoImpl extends EntidadeDaoImpl<Hospital> implements HospitalDao {

}
