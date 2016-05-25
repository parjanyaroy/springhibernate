package com.associationtest;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.manytomany.Course;
import com.manytoone.ClassTeacher;
import com.onetomany.Phone;
import com.onetoone.Address;

@Entity
@Table(name = "STUDENT")
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private long studentId;
	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	private String studentName;
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER) // example of simple one to one mapping
	private Address studentAddress;

	/**
	 * The @OneToMany annotation is used to create the one-to-many relationship
	 * between the Student and Phone entities. The @JoinTable annotation is used
	 * to create the STUDENT_PHONE link table and @JoinColumn annotation is used
	 * to refer the linking columns in both the tables.
	 */
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "STUDENT_PHONE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PHONE_ID") })
	private Set<Phone> studentPhoneNumbers = new HashSet<Phone>(0);

	/**
	 * The @ManyToOne annotation is used to create the many-to-one relationship
	 * between the Student and ClassTeacher entities. The cascade option is used
	 * to cascade the required operations to the associated entity. If the
	 * cascade option is set to CascadeType.ALL then all the operations will be
	 * cascaded. For instance when you save a Student object, the associated
	 * ClassTeacher object will also be saved automatically.
	 */

	//@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@ManyToOne(fetch=FetchType.EAGER)
	private ClassTeacher classTeacher;

	/**
	 * The @ManyToMany annotation is used to create the many-to-many
	 * relationship between the Student and Course entities. The @JoinTable
	 * annotation is used to create the STUDENT_COURSE link table
	 * and @JoinColumn annotation is used to refer the linking columns in both
	 * the tables.
	 */
	//cascade = CascadeType.ALL is removed
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "COURSE_ID") })
	private Set<Course> courses = new HashSet<Course>(0);

	public Student() {
	}

	public Student(String studentName, Set<Phone> studentPhoneNumbers, Address address1/*, ClassTeacher classTeacher, Set<Course> courses*/) {
		this.studentName = studentName;
		this.studentPhoneNumbers = studentPhoneNumbers;
		this.studentAddress = address1;
		//this.classTeacher = classTeacher;
		//this.courses=courses;
	}

	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Set<Phone> getStudentPhoneNumbers() {
		return this.studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(Set<Phone> studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
	}

	public ClassTeacher getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(ClassTeacher classTeacher) {
		this.classTeacher = classTeacher;
	}

	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (studentId ^ (studentId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.studentId==((Student)obj).studentId)
			return true;
		else
			return false;
	}
	

}
