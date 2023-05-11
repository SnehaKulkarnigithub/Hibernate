package com.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="Books")
@Table(name="Books" , uniqueConstraints = {
		@UniqueConstraint(columnNames = "bookid")
})
public class Books implements Serializable {
	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookid", unique = true, nullable = false)
	private Integer bookid;
	
	@Column(name="bookname", nullable = false)
	private String bookname;
	
	@Column(name="price", nullable = false)
	private Integer price;
	
	@ManyToMany(mappedBy = "books")
	private Set<Authors> author;

	public Books() {
		// TODO Auto-generated constructor stub
	}

	public Books(Integer bookid, String bookname, Integer price, Set<Authors> author) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.author = author;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Set<Authors> getAuthor() {
		return author;
	}

	public void setAuthor(Set<Authors> author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname
				+ ", price=" + price + "]";
	}

}
