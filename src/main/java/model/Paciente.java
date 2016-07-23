package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "PACIENTE" )
public class Paciente extends Entidade<Paciente> {

	private PessoaFisica pessoaFisica;
	private Double altura;
	private Double peso;
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica = pessoaFisica == null ? new PessoaFisica() : pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	@Column(name="ALTURA", precision = 3, scale = 2)
	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Column(name="PESO", precision = 5, scale = 2)
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
}
