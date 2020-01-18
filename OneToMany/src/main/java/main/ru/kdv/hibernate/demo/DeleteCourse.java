package main.ru.kdv.hibernate.demo;

import main.ru.kdv.hibernate.entity.Course;
import org.hibernate.Session;
import main.ru.kdv.hibernate.factory.ConfFactory;

public class DeleteCourse {
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
