package practice.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import practice.employee.entity.Employee;

import java.util.List;

public class DeleteEmployee {

    public static void main(String[] args) {

        // create session factory
        SessionFactory workFactory = new Configuration().configure("Emp-hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        // create session
        Session workSession = workFactory.getCurrentSession();

        try {
            System.out.println("Hello! Time to work! ");
            System.out.println();
            int employeeId = 6;

            // start a transaction
            workSession = workFactory.getCurrentSession();
            workSession.beginTransaction();

            // retrieve employee based on the id: primary key
            System.out.println("Getting employee with id: " + employeeId + ".");
            Employee myEmployee = workSession.get(Employee.class, employeeId);
            System.out.println();

            // delete the employee
            System.out.println("Deleting the employee with an id " + employeeId + "...");
            workSession.delete(myEmployee);

            // commit transaction
            workSession.getTransaction().commit();
            System.out.println();

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
