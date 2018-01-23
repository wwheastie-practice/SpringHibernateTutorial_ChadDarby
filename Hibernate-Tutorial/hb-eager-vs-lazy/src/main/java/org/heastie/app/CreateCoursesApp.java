package org.heastie.app;

import org.heastie.entity.Course;
import org.heastie.entity.Instructor;
import org.heastie.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesApp {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                                .configure()
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

            //Get instructor from database
            Instructor instructor =  session.get(Instructor.class, 1);

            //Create courses
            Course math = new Course("Calculus 1");
            Course science = new Course("Biology 2");
            Course history = new Course ("American History: 1800 - 1900");

            //Add courses to instructor
            instructor.add(math);
            instructor.add(science);
            instructor.add(history);

            //Save courses
            session.save(math);
            session.save(science);
            session.save(history);

            //Commit transaction
            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
