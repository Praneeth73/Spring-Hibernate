package com.hibernate.onetomanyuni.copy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.Course;
import com.luv2.code.hibernate.demo.entity.Review;
import com.luv2.code.hibernate.demo.entity.student;
import com.luv2code.hibernate.onetoone.Instructor;
import com.luv2code.hibernate.onetoone.InstructorDetail;

public class CreateCoursesAndReviewsDemo {

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
			
			int theId=10;
			//create a course 
			Course tempcourse = session.get(Course.class, theId);
			
			//add some reviews 
			tempcourse.addReview(new Review("good "));
			tempcourse.addReview(new Review("awesome "));
			
			//save the course .... leverage the cascade all
			session.save(tempcourse);

		session.getTransaction().commit();
		
		}
		finally {
			
			session.close();
			
			factory.close();
		}
	}

}
