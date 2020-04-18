package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.onetoone.Instructor;
import com.luv2code.hibernate.onetoone.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {

		session.beginTransaction();
		
		//get a instructor from db 
		
		int theId=1;
		Instructor tempInstructor = session.get(Instructor.class, theId);
		
		System.out.println("Instructor ... " + tempInstructor);
		
		//get courses for the iinstructor
		System.out.println("Courses for a instructoe..."+ tempInstructor.getCourses());
		

		session.getTransaction().commit();
		
		
		
		}
		finally {
			
			session.close();
			
			factory.close();
		}
	}

}
