package net.heastie.app;

import net.heastie.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Object.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        //Add employees
//        session.save(new Employee("Chad", "Darby", "luv2code"));
//        session.save(new Employee("Will", "Haste", "Jack Henry"));
//        session.save(new Employee("Sheeth", "Bladestorm", "OG"));

        //Delete employee(s)
        session.createQuery("delete from Employee where id='1'").executeUpdate();


        //session.getTransaction().commit();

        session.close();
        factory.close();
    }
}
