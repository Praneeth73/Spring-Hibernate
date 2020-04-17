package com.luv2code.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
		
		session.beginTransaction();
		
		//get the instructor by primary key/id 
		
		int theId=1;
		Instructor tempInstructor = session.get(Instructor.class,theId);
		
		System.out.println("Found Instructor: " + tempInstructor);
		
		//delete the instructor
		if(tempInstructor != null) {
			System.out.println("Deleting : " + tempInstructor);
			
			session.delete(tempInstructor);//this will also delete the Instructor detail as well because of cascading 
		}
	
		
		session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
