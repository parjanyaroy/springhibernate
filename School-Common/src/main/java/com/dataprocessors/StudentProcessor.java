package com.dataprocessors;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.associationtest.Student;
import com.manytomany.Course;

public class StudentProcessor {
	
	
	
	public List<Student> listStudents()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Student> results = entityManager.createQuery("Select s from Student s", Student.class).getResultList();
		entityManager.close();
		return results;
	}
	
	
	public void createStudent(Student student)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		student.setStudentId(0);
		
		// The following fragment helps to map both teacher and courses bidirectionally
		student.getClassTeacher().getStudent().add(student);
		entityManager.merge(student.getClassTeacher());
		for(Course c : student.getCourses())
		{
			c.getStudentsEnrolled().add(student);
			entityManager.merge(c);
		}
		// Fragment Ends
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void updateStudent (Student student)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Student studentForUpdate =  entityManager.find(Student.class,student.getStudentId());
		studentForUpdate=student;
		entityManager.merge(studentForUpdate);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	
	/* Function Serves the purpose of both deletion and finding out a single studen from id */
	public Student searchOrDleteStudent(long studentId,boolean delete) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Student student =  entityManager.find(Student.class,studentId);
		if (student != null && delete) {
			String del_studentCourse_link ="delete from student_course s where s.studentId="+studentId+"";
			Query createQuery = entityManager.createQuery(del_studentCourse_link);
			createQuery.executeUpdate();
			entityManager.remove(student);
			return null;
		    }
		entityManager.getTransaction().commit();
		entityManager.close();
		return student;
	}

}
