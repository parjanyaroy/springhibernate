package com.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.associationtest.Student;

@Entity
@Table(name = "COURSE")
public class Course {
	
	@Id
	@GeneratedValue
	@Column(name = "COURSE_ID")
	private long courseId;
	@Column(name = "COURSE_NAME", nullable = false)
	private String courseName;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Student> studentsEnrolled = new HashSet<Student>(0);
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (courseId ^ (courseId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Course other = (Course) obj;
		if (courseId != other.courseId)
			return false;
		return true;
	}

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	
	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(Set<Student> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

}