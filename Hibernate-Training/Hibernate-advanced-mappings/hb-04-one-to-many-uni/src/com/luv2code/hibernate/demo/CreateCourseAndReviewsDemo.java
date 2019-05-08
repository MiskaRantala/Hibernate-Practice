package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();
            System.out.println("Starting!\n");

            // Create a course
            System.out.println("Creating courses...");
            Course tempCourse = new Course("Perus Raimo - How to go slow");

            // Create some reviews for the course
            System.out.println("... and reviews! \n");
            tempCourse.addReview(new Review("Nice, got new records!"));
            tempCourse.addReview(new Review("Hard, but fair. Nice teacher! "));
            tempCourse.addReview(new Review("sonic is better then raimo raimo sux sonic is faster looooser lol umad!"));

            // Saving the course
            System.out.println("Now saving. Please wait!");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("\nDone!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
