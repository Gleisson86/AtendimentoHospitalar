package dao;

import org.springframework.stereotype.Repository;

import model.Cidade;

@Repository("cidadeDao")
class CidadeDaoImpl extends EntidadeDaoImpl<Cidade> implements CidadeDao {

}
