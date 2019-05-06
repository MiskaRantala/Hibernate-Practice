package practice.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import practice.employee.entity.Employee;

public class ReadEmployee {

    public static void main(String[] args) {

        // create session factory
        SessionFactory workFactory = new Configuration().configure("Emp-hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        // create session
        Session workSession = workFactory.getCurrentSession();

        try {
            System.out.println("Hello! Time to work! ");
            int EmployeeId = 2;

            // start a transaction
            workSession.beginTransaction();

            // retrieve employee based on the id: primary key
            System.out.println("Getting employee with id " + EmployeeId + "...");
            System.out.println();
            System.out.println("Hibernating...");
            Employee myEmployee = workSession.get(Employee.class, EmployeeId);

            System.out.println();
            System.out.println("Get complete! Information: " + myEmployee);
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
