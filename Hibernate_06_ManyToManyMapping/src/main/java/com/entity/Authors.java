package com.entity;

import java.io.Serializable;
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
@Table(name = "Authors")
public class Authors implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authid;
	private String authname;
	private String city;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "AUTHORS_BOOKS", 
	joinColumns = 
	{@JoinColumn(referencedColumnName = "authid")}, 
	inverseJoinColumns = 
	{@JoinColumn(referencedColumnName = "bookid")})
	
	private Set<Books> books;

}
