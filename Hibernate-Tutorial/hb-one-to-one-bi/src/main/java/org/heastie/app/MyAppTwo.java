package org.heastie.app;

import org.heastie.entity.Instructor;
import org.heastie.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyAppTwo {
    public static void main(String[] args) {

        //Create session factory
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

            //Get instructor by primary key
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Found instructor: " + instructor);

            //Delete instructor
            if(instructor != null) {
                System.out.println("Deleting: " + instructor);
                session.delete(instructor);
            }

            //Commit transaction
            session.getTransaction().commit();

            //Done
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
