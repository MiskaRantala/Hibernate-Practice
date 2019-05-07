package practice.employee;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import practice.employee.entity.Employee;

import java.util.List;

public class QueryEmployee {

    public static void main(String[] args) {

        // create session factory
        SessionFactory workFactory = new Configuration().configure("Emp-hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        // create session
        Session workSession = workFactory.getCurrentSession();

        try {
            System.out.println("Hello! Time to work! ");

            // start a transaction
            workSession.beginTransaction();

            // create the list
            List<Employee> theEmployees;

            // search for desired results: lastName='Rantala'
            System.out.println("Finding all employees with last name 'Rantala'... ");
            System.out.println();
            theEmployees = workSession.createQuery("FROM Employee e WHERE e.lastName='Rantala'").getResultList();
            System.out.println();

            // display the results
            displayEmployees(theEmployees);

            // commit transaction
            workSession.getTransaction().commit();

            System.out.println("Done! Shutting down... BZZZT!");
        }
        finally {
            workFactory.close();
        }

    }

    private static void displayEmployees(List<Employee> theEmployees) {
        for (Employee tempEmp : theEmployees) {
            System.out.println(tempEmp);
        }
    }


}
