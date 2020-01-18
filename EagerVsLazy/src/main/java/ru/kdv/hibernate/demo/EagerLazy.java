package ru.kdv.hibernate.demo;

import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.entity.Instructor;
import ru.kdv.hibernate.factory.ConfFactory;
import org.hibernate.Session;

import java.util.List;

public class EagerLazy {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {
            session.beginTransaction();
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            List<Course> courses = instructor.getCourses();

            System.out.println(courses);

            session.getTransaction().commit();

            session.close();
            // After close session with LAZY fetch we have exception
            // to avoid can call this method while session is open 19 line
            System.out.println(instructor.getCourses());

        } finally {
            cf.closeCurrentSession();
        }
    }
}
