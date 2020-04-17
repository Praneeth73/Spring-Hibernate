package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2.code.hibernate.demo.entity.student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the student object
			System.out.println("creating new student object....");
			student tempstudent = new student("paul", "wall", "paul@luv2code.com");
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student");
			session.save(tempstudent);
			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
