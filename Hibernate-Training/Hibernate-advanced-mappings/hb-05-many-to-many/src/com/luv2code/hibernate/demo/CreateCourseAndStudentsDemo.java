package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

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

            // create the courses
            System.out.println("Creating courses...");
            Course tempCourse1 = new Course("Perus Raimo - How to drive");
            Course tempCourse2 = new Course("Perus Raimo - How to build a computer");
            Course tempCourse3 = new Course("Perus Raimo - How to steal from old people");
            System.out.println("Courses created!");

            // save the courses
            System.out.println("\nSaving the courses...");
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.save(tempCourse3);
            System.out.println("Courses saved!\n");

            // create the students
            Student tempStudent1 = new Student("Roope", "Paasonen", "roope.ranta.com");
            Student tempStudent2 = new Student("Antti", "Aamunen", "antti.ranta.com");

            // add students to the course
            System.out.println("Adding students to courses...");
            tempCourse1.addStudent(tempStudent1);
            tempCourse1.addStudent(tempStudent2);
            tempCourse2.addStudent(tempStudent2);
            tempCourse3.addStudent(tempStudent1);
            System.out.println("Students added!\n");

            // save the students
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved!\n");

            // show the students in courses
            System.out.println("These students were added to these courses: ");
            System.out.println("Course 1: " + tempCourse1.getStudents());
            System.out.println("Course 2: " + tempCourse2.getStudents());
            System.out.println("Course 3: " + tempCourse3.getStudents() + "\n");

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
