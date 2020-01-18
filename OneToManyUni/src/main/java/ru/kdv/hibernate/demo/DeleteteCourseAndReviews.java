package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.factory.ConfFactory;

public class DeleteteCourseAndReviews {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {

            session.beginTransaction();

            int id = 10;

            Course course = session.get(Course.class, id);

            session.delete(course);

            session.getTransaction().commit();

        } finally {
            cf.closeCurrentSession();
        }
    }
}
