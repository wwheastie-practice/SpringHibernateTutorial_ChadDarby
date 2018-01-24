package org.heastie.app;

import org.heastie.entity.Instructor;
import org.heastie.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyAppFour {
    public static void main(String[] args) {

        //Create session factory
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

            //Get instructor by primary key
            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            //Remove the associated object reference
            instructorDetail.getInstructor().setInstructorDetail(null);

            //Delete instructorDetail
            session.delete(instructorDetail);

            //Commit transaction
            session.getTransaction().commit();

            //Done
            System.out.println("Done!");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
