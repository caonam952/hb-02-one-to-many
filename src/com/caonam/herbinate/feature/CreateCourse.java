package com.caonam.herbinate.feature;

import com.caonam.herbinate.entity.Course;
import com.caonam.herbinate.entity.Instructor;
import com.caonam.herbinate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourse {
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
            System.out.println("Get Instructor on id = " + theId);
            Instructor tempInstructor = session.get(Instructor.class, theId);

            // create new course
            Course tempCourse = new Course("Java");
            Course tempCourse2 = new Course("Spring");

            // add course on instructor
            tempInstructor.add(tempCourse);
            tempInstructor.add(tempCourse2);

            // save course
            session.save(tempCourse);
            session.save(tempCourse2);

            session.getTransaction().commit();

        }finally {
            session.close();

            factory.close();
        }
    }
}
