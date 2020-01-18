package ru.kdv.hibernate.demo;

import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.factory.ConfFactory;
import org.hibernate.Session;

public class GetCourseAndReviews {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {

            session.beginTransaction();

            int id = 10;

            Course course = session.get(Course.class, id);

            System.out.println(course);
            System.out.println(course.getReviews());

            session.getTransaction().commit();

        } finally {
            cf.closeCurrentSession();
        }
    }
}
