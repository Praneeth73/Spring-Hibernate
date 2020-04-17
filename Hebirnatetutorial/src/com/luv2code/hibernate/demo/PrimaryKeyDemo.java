package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2.code.hibernate.demo.entity.student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the student object
			System.out.println("creating new student object....");
			student tempstudent1 = new student("john", "Doe", "paul@luv2code.com");
			student tempstudent2 = new student("Mary", "public", "mary@luv2code.com");
			student tempstudent3 = new student("Bonita", "Applebum", "bonita@luv2code.com");
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student");
			session.save(tempstudent1);
			session.save(tempstudent2); 
			session.save(tempstudent3);
			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
}
