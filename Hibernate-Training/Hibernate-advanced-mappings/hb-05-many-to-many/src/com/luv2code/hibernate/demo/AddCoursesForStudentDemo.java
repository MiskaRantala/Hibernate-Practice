package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudentDemo {

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

            // get the student from database
            System.out.println("Choosing a student from database...");
            int studentId = 1;
            Student tempStudent = session.get(Student.class, studentId);
            System.out.println("Chosen student: " + tempStudent + "\n");

            // get the course from database
            System.out.println("Choosing a course from database...");
            int courseId = 19;
            Course tempCourse = session.get(Course.class, courseId);
            System.out.println("Chosen course: " + tempCourse + "\n");

            // add students to the course
            System.out.println("Adding student to the course...");
            tempCourse.addStudent(tempStudent);
            System.out.println("Student added!\n");

            // save the course
            System.out.println("Saving the course...");
            session.save(tempStudent);
            System.out.println("Saved!\n");

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
