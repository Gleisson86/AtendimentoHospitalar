package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ATENDIMENTO")
public class Atendimento extends Entidade<Atendimento> {

	private Date horario;
	private Hospital hospital;
	private Paciente paciente;
	private Medico medico;
	private List<Sintoma> sintomas = new ArrayList<Sintoma>();
	
	@Temporal(TemporalType.TIME)
	@Column(name="HORARIO")
	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	@ManyToOne
	@JoinColumn( name = "HOSPITAL_ID" )
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@ManyToOne
	@JoinColumn( name = "PACIENTE_ID" )
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	@ManyToOne
	@JoinColumn( name = "MEDICO_ID" )
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atendimento", cascade = CascadeType.ALL, targetEntity=Sintoma.class)
	public List<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}
}
