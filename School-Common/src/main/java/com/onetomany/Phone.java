package com.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.associationtest.Student;

@Entity
@Table(name = "PHONE")
public class Phone {

	@Id
	@GeneratedValue
	@Column(name = "PHONE_ID")
	private long phoneId;
	@Column(name = "PHONE_TYPE", nullable = false, length = 10)
	private String phoneType;
	@Column(name = "PHONE_NUMBER", nullable = false, length = 15)
	private String phoneNumber;
	/**
	 * Following declaration makes the relationship bidirectional 
	 */
	@ManyToOne
	private Student student;

	public Phone() {
	}
	public Phone(String phoneType, String phoneNumber,Student student) {
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
		this.student=student;
	}
	public long getPhoneId() {
		return this.phoneId;
	}
	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}
	public String getPhoneType() {
		return this.phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}