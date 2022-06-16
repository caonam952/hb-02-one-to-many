package com.caonam.herbinate.feature;

import com.caonam.herbinate.entity.Course;
import com.caonam.herbinate.entity.Instructor;
import com.caonam.herbinate.entity.InstructorDetail;
import com.caonam.herbinate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReview {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println("Deleting the Course: " + tempCourse);
            System.out.println("Review: " + tempCourse.getReviews());

            session.delete(tempCourse);

            session.getTransaction().commit();

        }finally {
            session.close();

            factory.close();
        }
    }
}
