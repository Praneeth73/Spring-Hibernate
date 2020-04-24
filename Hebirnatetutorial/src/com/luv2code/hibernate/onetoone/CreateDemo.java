package com.luv2code.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.Course;
import com.luv2.code.hibernate.demo.entity.Review;
import com.luv2.code.hibernate.demo.entity.student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(student.class)
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
