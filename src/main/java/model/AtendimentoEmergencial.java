package main.java.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "Emergencial" )
public class AtendimentoEmergencial extends Atendimento<AtendimentoEmergencial> {

}
