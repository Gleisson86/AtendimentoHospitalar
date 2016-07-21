package main.java.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "Clinico" )
public class AtendimentoClinico extends Atendimento<AtendimentoClinico> {

}
