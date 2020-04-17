package com.luv2code.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BionetooneDelete {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
		
		session.beginTransaction();
		
		//get the instructordetail object  by primary key/id 
		
		int theId=3;
		InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);
		
		System.out.println("Found Instructor: " + tempInstructorDetail.getInstructor());

		session.getTransaction().commit();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
