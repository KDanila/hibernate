package main.java.ru.kdv.hibernate.demo;

import main.java.ru.kdv.hibernate.entity.Course;
import main.java.ru.kdv.hibernate.entity.Instructor;
import main.java.ru.kdv.hibernate.entity.InstructorDetail;
import main.java.ru.kdv.hibernate.factory.ConfFactory;
import org.hibernate.Session;

public class AddCoursesToExistingInstructor {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {
            session.beginTransaction();
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            Course course1 = new Course("Caligraphy");
            Course course2 = new Course("Java education");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

        } finally {
            cf.closeCurrentSession();
        }
    }
}
