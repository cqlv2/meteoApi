package dev.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SuperDto {

	protected Long id;
	protected LocalDateTime dateAdd = LocalDateTime.now();

	// pas de constructeur car on veut pas de constructeur dans les dtoQuery!
	// id et date add seron hydrater dans le constructeur de dtoResponse

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(LocalDateTime dateAdd) {
		this.dateAdd = dateAdd;
	}

}
