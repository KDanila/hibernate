package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.entity.Instructor;
import ru.kdv.hibernate.factory.ConfFactory;

import java.util.List;

public class GetInstructorCourses {
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

        } finally {
            cf.closeCurrentSession();
        }
    }
}
