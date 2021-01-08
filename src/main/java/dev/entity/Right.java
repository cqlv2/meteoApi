package dev.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import dev.enumeration.RightEnum;

@Entity
@Table(name = "right_")
public class Right extends SuperEntity {

	@Enumerated(EnumType.STRING)
	private RightEnum label;
	@ManyToMany
	@JoinTable(
			name = "role_has_right", 
			joinColumns = @JoinColumn(name="right_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"), 
			uniqueConstraints = @UniqueConstraint(columnNames = {"role_id","right_id"}))
	private List<Role>roles;
	
	//getteur setteur
	
	public RightEnum getLabel() {
		return label;
	}
	public void setLabel(RightEnum label) {
		this.label = label;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
