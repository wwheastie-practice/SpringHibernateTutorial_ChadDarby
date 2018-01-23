package org.heastie.app;

import org.heastie.entity.Course;
import org.heastie.entity.Instructor;
import org.heastie.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesApp {
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
            System.out.println("Instructor: " + instructor);

            //Get course for the instructor
            System.out.println("Courses: " + instructor.getCourses());

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
