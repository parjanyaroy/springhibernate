package com.associationtest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dataprocessors.CourseProcessor;
import com.dataprocessors.TeacherProcessor;
import com.manytomany.Course;
import com.manytoone.ClassTeacher;
import com.onetomany.Phone;
import com.onetoone.Address;

public class AssociationTest {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		// -- Creating list of courses
		Course c_maths = new Course();
		c_maths.setCourseName("Maths");
		Course c_physics = new Course();
		c_physics.setCourseName("Physics");
		Course c_history = new Course();
		c_history.setCourseName("History");
		Course c_computer = new Course();
		c_computer.setCourseName("Computer");
		Course c_english = new Course();
		c_english.setCourseName("English");
		
		entityManager.persist(c_maths);
		entityManager.persist(c_physics);
		entityManager.persist(c_history);
		entityManager.persist(c_computer);
		entityManager.persist(c_english);
		// -- Creation Of Courses Complete
		
		
		// -- Creating List Of Teachers
		ClassTeacher t1 = new ClassTeacher("Anindya Karmakar","Cptr");
		ClassTeacher t2 = new ClassTeacher("Sadhana Halder","Arts");
		ClassTeacher t3 = new ClassTeacher("Arijit Roy","Sci");
		ClassTeacher t4 = new ClassTeacher("Sandip Ghosh","Muz");
		entityManager.persist(t1);
		entityManager.persist(t2);
		entityManager.persist(t3);
		entityManager.persist(t4);
		// -- List Of Teachers Completed
		
		
		
		// Just Associating a Student With Address And Phone Number 	
		Address address1 = new Address("OMR Road", "Chennai", "TN", "600097");
		Set<Phone> phoneNumbers = new HashSet<Phone>();
		Student student1 = new Student("Eswar",phoneNumbers, address1);
		phoneNumbers.add(new Phone("house","32354353",student1));
		phoneNumbers.add(new Phone("mobile","9038831096",student1));
		entityManager.persist(student1);
		address1.setStudent(student1);
		// Bidirectional Association of a student with address and phone is complete

		
		
		
		 
		
		// Just Associating a Student With Address And Phone Number And Teacher And Course 	
		
		Address address2 = new Address("Ring Road", "Banglore", "Karnataka", "560000");
		Set<Phone> phoneNumbers2 = new HashSet<Phone>();
		Student student2 = new Student("Joe",phoneNumbers2, address2);
		phoneNumbers2.add(new Phone("house","32354353",student2));
		phoneNumbers2.add(new Phone("mobile","9889343423",student2));
		entityManager.persist(student2);
		address2.setStudent(student2);
		
		
		// Bidirectional Association of a student with address and phone is complete		
		
		
		
			
			
			
		/*Set<Student> studentsForCourses1 = new HashSet<Student>();
		Set<Course> courses1 = new HashSet<Course>();
		Set<Course> courses2 = new HashSet<Course>();
			
			
			
			ClassTeacher supremeTeacher = new ClassTeacher("Anindya Karmakar", "Computer");
			
			studentsForCourses1.add(student1);
			studentsForCourses1.add(student2);
			Course c1 = new Course();
			c1.setCourseName("Maths");
			c1.setStudentsEnrolled(studentsForCourses1);
			
			courses1.add(c1);
			courses1.add(new Course("Computer Science"));
			courses2.add(new Course("Chem"));
			courses2.add(new Course("Phy"));
			
			Set<Student> classStudents = new HashSet<Student>();
			classStudents.add(student1);
			classStudents.add(student2);
			supremeTeacher.setStudent(classStudents);
			
			
			
			
			entityManager.persist(supremeTeacher);*/
			entityManager.getTransaction().commit();
			entityManager.close();
			
			/**
			 * ASSOCIATING A STUDENT WITH A COURSE AND TEACHER AT A LATER STAGE.
			 */
			
			// Creating relation between Eshwar and Arijit Roy 
			(new TeacherProcessor()).addTeacherToStudent(student1.getStudentId(), t3.getTeacherId());
			// Link Creation Complete
			
			// Enrolling Eshwar in two courses
			(new CourseProcessor()).addCoursesToStudent(student1.getStudentId(), new long[]{c_maths.getCourseId(),c_physics.getCourseId()});
			(new CourseProcessor()).addCoursesToStudent(student1.getStudentId(), new long[]{c_computer.getCourseId(),c_physics.getCourseId()});
			// Enrolled
			
			/** BIDIRECTIONAL ASSOCIATION COMPLETE */
			
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			List<Student> results = entityManager.createQuery("Select s from Student s", Student.class).getResultList();
			/*for (Student student : results) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println(student.getStudentName()+" is from "+student.getStudentAddress().getCity());
				Set<Phone> storedNumbers= student.getStudentPhoneNumbers();
				for (Phone phone : storedNumbers) {
					System.out.println("\t Type:"+phone.getPhoneType()+" Number:"+phone.getPhoneNumber());
				}
				for(Course course : student.getCourses())
				{
					System.out.println("Subject: "+course.getCourseName());
					System.out.println("\t Students Enrolled in This Course");
					for (Student student11 : course.getStudentsEnrolled()) {
						System.out.println("\t"+student11.getStudentName());
					}
				}
				System.out.println("Class Teacher: "+student.getClassTeacher().getTeacherName());
				
				
			}*/
			entityManager.close();
			
				

	}

}
