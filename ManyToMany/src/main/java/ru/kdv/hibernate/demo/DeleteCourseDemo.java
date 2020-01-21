package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.entity.Student;
import ru.kdv.hibernate.factory.ConfFactory;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {
            session.beginTransaction();

            Integer id = 10;
            Course courseToDelete = session.get(Course.class, id);

            session.delete(courseToDelete);

            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
