package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PessoaJuridica extends Pessoa {

	private String cnpj;
	
	@Column(name="CNPJ", length=18)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	
}
