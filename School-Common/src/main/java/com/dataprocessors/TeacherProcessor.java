package com.dataprocessors;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.associationtest.Student;
import com.manytoone.ClassTeacher;

public class TeacherProcessor {
	
	public List<ClassTeacher> listTeachers()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<ClassTeacher> results = entityManager.createQuery("Select t from ClassTeacher t", ClassTeacher.class).getResultList();
		entityManager.close();
		return results;
	}
	
	
	public ClassTeacher listTeachers(long teacherId)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		ClassTeacher result = entityManager.createQuery("Select t from ClassTeacher t where t.teacherId=:tchrId", ClassTeacher.class).setParameter("tchrId", teacherId).getSingleResult();
		entityManager.close();
		return result;
	}
	
	public void addTeacherToStudent(long studentId,long teacherId)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		ClassTeacher teacher = entityManager.createQuery("Select t from ClassTeacher t where t.teacherId=:tchrId", ClassTeacher.class).setParameter("tchrId", teacherId).getSingleResult();
		Student student = entityManager.createQuery("Select s from Student s where s.studentId=:stdntId", Student.class).setParameter("stdntId", studentId).getSingleResult();
		student.setClassTeacher(teacher);
		teacher.getStudent().add(student);
		entityManager.getTransaction().commit();
		entityManager.close();
	}


	public void addTeacher(ClassTeacher teacherReg) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(teacherReg);
		entityManager.getTransaction().commit();
		entityManager.close();
	
		
	}

}
