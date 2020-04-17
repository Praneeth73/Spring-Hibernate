package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2.code.hibernate.demo.entity.student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			// start a transaction
			session.beginTransaction();
			
			//query students
			List<student> thestudents = session.createQuery("from student").list();
			
			displayStudents(thestudents);
			
			thestudents= session.createQuery("from student s where s.lastName='Doe'").list();
			// commit transaction
			displayStudents(thestudents);
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<student> thestudents) {
		for(student s : thestudents) {
			System.out.println(s);
		}
	}

}
