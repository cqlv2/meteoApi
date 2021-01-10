package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import dev.enumeration.RoleEnum;

@Entity
public class Role extends SuperEntity {

	@Enumerated(EnumType.STRING)
	private RoleEnum label;
	@ManyToMany
	@JoinTable(name = "role_has_right", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "right_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"role_id", "right_id" }))
	private List<Right> rights = new ArrayList<>();

	@OneToMany(targetEntity = Member.class, mappedBy = "role")
	private List<Member> members = new ArrayList<>();

	// getteur setteur

	public RoleEnum getLabel() {
		return label;
	}

	public void setLabel(RoleEnum label) {
		this.label = label;
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}
