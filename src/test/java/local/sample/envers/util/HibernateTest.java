package local.sample.envers.util;

import local.sample.evners.entity.Department;
import local.sample.evners.entity.Employee;
import local.sample.evners.util.HibernateUtil;

import org.hibernate.*;

public class HibernateTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        createEmployees(session);
        session.beginTransaction();
        Employee employee = (Employee) session.load(Employee.class, 1L);

        alterEmployee(session, employee);
    }

    private static void alterEmployee(Session session, Employee emp) {
        session.beginTransaction();
        Department dept = new Department("Hardware");
        emp.setName(emp.getName() + "1");
        session.getTransaction().commit();

        session.beginTransaction();
        emp.setName(emp.getName() + "12");
        emp.setDescription("add desc32");
        session.getTransaction().commit();

        session.beginTransaction();
        emp.setName(emp.getName() + "1");
        session.save(dept);
        emp.setDepartment(dept);
        session.getTransaction().commit();
    }

    private static void createEmployees(Session session) {
        session.save(new Employee("Jakab Gipsz"));
        session.save(new Employee("Captain Nemo"));

        session.getTransaction().commit();
    }

}
