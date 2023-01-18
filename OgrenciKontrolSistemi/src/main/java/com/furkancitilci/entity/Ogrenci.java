package com.furkancitilci.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

//@NamedQueries({
//	@NamedQuery(name = "Ogrenci.findAll", query = "SELECT o FROM Ogrenci o"),    // JPQL => select * from student
//	@NamedQuery(name = "Ogrenci.findById", query = "SELECT o FROM Ogrenci o WHERE o.id = :id")   // JPQL
	
//})
@Entity
public class Ogrenci {
	
	@Id
	@GeneratedValue	
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	@Column(nullable = false, name = "address1")
	private String address1;
	@Column(nullable = false, name = "address2")
	private String address2;
	@Column(nullable = false, name = "tel_no1")
	private String telNo1;
	@Column(nullable = false, name = "tel_no2")
	private String telNo2;
	
	
	public Ogrenci() {
		
	}

	
	
	public Ogrenci(int id, String email, String firstName, String lastName, String gender, String address1,
			String address2, String telNo1, String telNo2) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address1 = address1;
		this.address2 = address2;
		this.telNo1 = telNo1;
		this.telNo2 = telNo2;
	}



	public Ogrenci(String email, String firstName, String lastName, String gender, String address1, String address2,
			String telNo1, String telNo2) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address1 = address1;
		this.address2 = address2;
		this.telNo1 = telNo1;
		this.telNo2 = telNo2;
	}


	public Ogrenci(String email, String firstName, String lastName, String gender, String address1, String telNo1) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address1 = address1;
		this.telNo1 = telNo1;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getTelNo1() {
		return telNo1;
	}


	public void setTelNo1(String telNo1) {
		this.telNo1 = telNo1;
	}


	public String getTelNo2() {
		return telNo2;
	}


	public void setTelNo2(String telNo2) {
		this.telNo2 = telNo2;
	}


	@Override
	public String toString() {
		return "Ogrenci [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", address1=" + address1 + ", address2=" + address2 + ", telNo1=" + telNo1
				+ ", telNo2=" + telNo2 + "]";
	}

	
	


	
	
}
