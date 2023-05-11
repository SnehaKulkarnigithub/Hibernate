package com.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Authors")
@Table(name = "Authors")
public class Authors implements Serializable {
	private static final long serialVersionUID = -1798070786993154676L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authid", unique = true, nullable = false)
	private Integer authid;

	@Column(name = "authname", unique = false, nullable = false)
	private String authname;

	@Column(name = "city", unique = false, nullable = false)
	private String city;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "BOOKS_AUTHORS", joinColumns = {
			@JoinColumn(referencedColumnName = "authid") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "bookid") })
	private Set<Books> books;

	public Authors() {
		// TODO Auto-generated constructor stub
	}

	public Authors(Integer authid, String authname, String city, Set<Books> books) {
		super();
		this.authid = authid;
		this.authname = authname;
		this.city = city;
		this.books = books;
	}

	public Integer getAuthid() {
		return authid;
	}

	public void setAuthid(Integer authid) {
		this.authid = authid;
	}

	public String getAuthname() {
		return authname;
	}

	public void setAuthname(String authname) {
		this.authname = authname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Authors [authid=" + authid + " authname=" + authname + " city=" + city + " ]";
	}

}
