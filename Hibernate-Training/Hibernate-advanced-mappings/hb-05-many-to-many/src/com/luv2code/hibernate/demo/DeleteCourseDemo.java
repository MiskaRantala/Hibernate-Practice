package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();
            System.out.println("Starting!\n");

            // get the course from database
            System.out.println("Choosing a course from database...");
            int courseId = 12;
            Course tempCourse = session.get(Course.class, courseId);
            System.out.println("Chosen course: " + tempCourse + "\n");

            // delete the course
            System.out.println("Delete the course...");
            session.delete(tempCourse);
            System.out.println("Deleted!\n");

            // commit transaction
            System.out.println("Committing...");
            session.getTransaction().commit();

            System.out.println("\nDone! Shutting down...\n");
        }
        finally {
            // Stop leaking
            session.close();
            factory.close();
        }

    }
}
