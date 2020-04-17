package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2.code.hibernate.demo.entity.student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the student object
			System.out.println("Reading a student object....");
			student tempstudent = new student("paul", "wall", "paul@luv2code.com");
			// start a transaction
			session.beginTransaction();
			session.save(tempstudent);
			// save the student object
			System.out.println("Saving the student");
			student mystudent = session.get(student.class, tempstudent.getId());
			// commit transaction
			System.out.println("Get complete"+mystudent);
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
