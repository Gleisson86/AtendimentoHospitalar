package main.java.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entidade<E extends Entidade<E>> {

	private Long id;
	
	@Id
	@Column(name="ID", precision=18, scale=0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
