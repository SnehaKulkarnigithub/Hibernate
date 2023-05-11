package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="university")
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniid")
	private int uniid;
	@Column(name = "uniname")
	private String uniname;
	@Column(name = "city")
	private String city;
	@Column(name = "website")
	private String website;
	
	public University() {
		
	}
	
	public University(String uniname, String city, String website) {
		super();
		this.uniname = uniname;
		this.city = city;
		this.website = website;
	}

	public University(int uniid, String uniname, String city, String website) {
		super();
		this.uniid = uniid;
		this.uniname = uniname;
		this.city = city;
		this.website = website;
	}
	public int getUniid() {
		return uniid;
	}
	public void setUniid(int uniid) {
		this.uniid = uniid;
	}
	public String getUniname() {
		return uniname;
	}
	public void setUniname(String uniname) {
		this.uniname = uniname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Override
	public String toString() {
		return "University [uniid=" + uniid + ", uniname=" + uniname + ", city=" + city + ", website=" + website + "]";
	}
	
}
