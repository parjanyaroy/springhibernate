package com.manytoone;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.associationtest.Student;

@Entity
@Table(name = "TEACHER")
public class ClassTeacher {

	@Id
	@GeneratedValue
	@Column(name = "TEACHER_ID")
	private long teacherId;
	@Column(name = "TEACHER_NAME")
	private String teacherName;
	@Column(name = "TEACHER_SUBJECT")
	private String teacherSubject;
	/**
	 * The following declaration makes the many to one relationship from student
	 * to class teacher bidirectional
	 */
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "STUDENT_TEACHER", joinColumns = { @JoinColumn(name = "TEACHER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "STUDENT_ID") })
	private Set<Student> student = new HashSet<Student>(0);

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(String teacherSubject) {
		this.teacherSubject = teacherSubject;
	}

	public ClassTeacher(String teacherName, String teacherSubject) {
		super();
		this.teacherName = teacherName;
		this.teacherSubject = teacherSubject;
	}

	public ClassTeacher() {

	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

}
