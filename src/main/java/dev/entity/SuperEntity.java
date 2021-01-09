package dev.entity;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * superclass extended to all entities. add a unique self-generated identifier
 * to all entities
 * 
 * @author cql-v2
 * @version 1.0
 */
@MappedSuperclass
public abstract class SuperEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected LocalDate dateAdd = LocalDate.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(LocalDate dateAdd) {
		this.dateAdd = dateAdd;
	}

}
