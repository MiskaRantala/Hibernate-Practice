package practice.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import practice.employee.entity.Employee;

public class CreateEmployee {

    public static void main(String[] args) {

        // create session factory
        SessionFactory workFactory = new Configuration().configure("Emp-hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        // create session
        Session workSession = workFactory.getCurrentSession();

        try {
            System.out.println("Hello! Time to work! ");

            //create a student object
            System.out.println("Creating 3 employees from file 'CreateEmployee.java'...");
            Employee tempEmp1 = new Employee("Vilma", "Vastamäki", "Valmet");
            Employee tempEmp2 = new Employee("Juuso", "Häkkinen", "Adecco");
            Employee tempEmp3 = new Employee("Vili", "Kinnunen", "Futurice");
            System.out.println();

            // start a transaction
            workSession.beginTransaction();

            // save the student object
            System.out.println("Saving employees... Please wait... ");
            workSession.save(tempEmp1);
            workSession.save(tempEmp2);
            workSession.save(tempEmp3);
            System.out.println();

            // commit transaction
            workSession.getTransaction().commit();

            System.out.println("Done! Shutting down... BZZZT!");
        }
        finally {
            workFactory.close();
        }

    }


}
