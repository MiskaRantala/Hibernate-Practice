package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the instructor from database
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Codnic: Instructor: " + tempInstructor);

            System.out.println("Codnic: Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            session.close();
            System.out.println("\nSession is now closed. Thank you for playing codary game. \n");

            // get courses for the instructor
            System.out.println("Codnic: Courses: " + tempInstructor.getCourses());

            System.out.println("Codnic: Done!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}