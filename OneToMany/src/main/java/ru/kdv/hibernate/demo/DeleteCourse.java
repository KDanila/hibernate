package main.java.ru.kdv.hibernate.demo;

import main.java.ru.kdv.hibernate.entity.Course;
import main.java.ru.kdv.hibernate.entity.Instructor;
import main.java.ru.kdv.hibernate.factory.ConfFactory;
import org.hibernate.Session;

import java.util.List;

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
