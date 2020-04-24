package com.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.Course;
import com.luv2.code.hibernate.demo.entity.Review;
import com.luv2.code.hibernate.demo.entity.student;
import com.luv2code.hibernate.onetoone.Instructor;
import com.luv2code.hibernate.onetoone.InstructorDetail;

public class DeleteStudentNotCourses {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			session.beginTransaction();
			
			//get the course 
			int theId = 2;
			student tempstudent = session.get(student.class, theId);
			
			//delete the course
			session.delete(tempstudent);
			
			
			session.getTransaction().commit();
		
		}
		finally {
			
			session.close();
			
			factory.close();
		}
	}

}
