package com.caonam.herbinate.feature;

import com.caonam.herbinate.entity.Course;
import com.caonam.herbinate.entity.Instructor;
import com.caonam.herbinate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourse {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            // get Instructor
            int theId = 1;
            System.out.println("##Get Instructor on id = " + theId);
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("##Instructor Information: " + tempInstructor);

            System.out.println("##Course: " + tempInstructor.getCourses());
            session.getTransaction().commit();

        }finally {
            session.close();

            factory.close();
        }
    }
}
