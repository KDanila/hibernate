package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.entity.Instructor;
import ru.kdv.hibernate.entity.InstructorDetail;
import ru.kdv.hibernate.entity.Review;
import ru.kdv.hibernate.factory.ConfFactory;

public class CreateCourseAndReviews {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {

            session.beginTransaction();

            Course course = new Course("Vim - how to escape");

            course.addRewiew(new Review("Yeh! I can quit!"));
            course.addRewiew(new Review("Amazing, it's really has quit option!"));
            course.addRewiew(new Review("I still can't install it!"));

            session.save(course);

            session.getTransaction().commit();

        } finally {
            cf.closeCurrentSession();
        }
    }
}
