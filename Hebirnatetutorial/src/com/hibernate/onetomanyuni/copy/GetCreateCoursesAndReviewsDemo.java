package com.hibernate.onetomanyuni.copy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.Course;
import com.luv2.code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.onetoone.Instructor;
import com.luv2code.hibernate.onetoone.InstructorDetail;

public class GetCreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
		session.beginTransaction();

		int theId = 10;
		//get the course 
		
		Course tempCourse = session.get(Course.class, theId);
		
		//print the course
		System.out.println("the temp course ... "+tempCourse);
		
		//print out the reviews		
		System.out.println("reviews ... "+tempCourse.getReviews());
		
		session.getTransaction().commit();
		
		}
		finally {
			
			session.close();
			
			factory.close();
		}
	}

}
