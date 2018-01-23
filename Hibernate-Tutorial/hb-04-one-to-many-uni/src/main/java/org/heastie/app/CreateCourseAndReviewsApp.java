package org.heastie.app;

import org.heastie.entity.Course;
import org.heastie.entity.Instructor;
import org.heastie.entity.InstructorDetail;
import org.heastie.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsApp {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                                .configure()
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .addAnnotatedClass(Review.class)
                                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

            //Create a course
            Course course = new Course("Biology");

            //Add reviews
            Review reviewOne = new Review("Love the class!!!");
            Review reviewTwo = new Review("Best class in NA!");
            course.addReview(reviewOne);
            course.addReview(reviewTwo);

            //Save the course
            session.save(course);

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
