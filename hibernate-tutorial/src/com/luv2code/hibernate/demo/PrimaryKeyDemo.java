package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            //create 3 student objects
            System.out.println("Create 3");
            Student tempStudent1 = new Student("Jani", "Mattila", "jani@trukki.fi");
            Student tempStudent2 = new Student("Janina", "Mattinen", "janina@trekki.fi");
            Student tempStudent3 = new Student("Janita", "Mattilainen", "janita@trakki.fi");

            // start a transaction
            session.beginTransaction();

            // save the student objects
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }



    }
}
