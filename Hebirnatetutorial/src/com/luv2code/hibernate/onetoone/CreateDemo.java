package com.luv2code.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
		
		
		Instructor tempInstructor = new Instructor("chad","Darby","darby@gmail.com");
		
		InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com","luv2code");
		
		System.out.println("saving instructor..."+tempInstructor);
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		session.beginTransaction();
		
		//save the instructor
		session.save(tempInstructor);//because of cascade it automatically saves the associated table (instructor detail)
		
		session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
