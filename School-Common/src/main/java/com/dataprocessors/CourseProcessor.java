package com.dataprocessors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.associationtest.Student;
import com.manytomany.Course;
import com.manytoone.ClassTeacher;

public class CourseProcessor {

	public List<Course> listCourses() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Course> results = entityManager.createQuery("Select c from Course c", Course.class).getResultList();
		entityManager.close();
		return results;
	}

	public Set<Course> listCourses(String courseIds) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Course> result = entityManager
				.createQuery("Select c from Course c where c.courseId IN ("+courseIds+")", Course.class).getResultList();
		entityManager.close();
		Set<Course> courseSet = new HashSet();
		for(Course c1 : result)
		{
			courseSet.add(c1);
		}
		return courseSet;
	}
	
	public void addCoursesToStudent(long studentId,long[] courseIds)
	{
		String courseIdString="";
		for(long l : courseIds)
		{
			courseIdString+=l+",";
		}
		courseIdString=courseIdString.substring(0, courseIdString.length()-1);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Student student = entityManager.createQuery("Select s from Student s where s.studentId=:stdntId", Student.class).setParameter("stdntId", studentId).getSingleResult();
		//ClassTeacher teacher = entityManager.createQuery("Select t from ClassTeacher t where t.teacherId=:tchrId", ClassTeacher.class).setParameter("tchrId", teacherId).getSingleResult();
		Set<Course> listCourses = listCourses(courseIdString);
		for (Course course : listCourses) {
			course.getStudentsEnrolled().add(student);
			entityManager.merge(course);
		}
		student.getCourses().addAll(listCourses);	
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void addCourse(Course course)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(course);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
