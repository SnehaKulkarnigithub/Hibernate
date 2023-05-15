package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empid;
	private String empname;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_PROJECT", 
	joinColumns = 
	{@JoinColumn(referencedColumnName = "empid")}, 
	inverseJoinColumns = 
	{@JoinColumn(referencedColumnName = "pid")})
	private Set<Projects> projects;

}
