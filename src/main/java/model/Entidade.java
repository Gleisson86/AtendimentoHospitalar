package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entidade<E extends Entidade<E>> {

	private Long id;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="ID", precision=18, scale=0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (!obj.getClass().getName().equals(this.getClass().getName())) {
			return false;
		}
		return this.id == ((E) obj).getId();
	}
}
