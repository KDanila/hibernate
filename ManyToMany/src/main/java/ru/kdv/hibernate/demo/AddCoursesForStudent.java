package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.entity.Student;
import ru.kdv.hibernate.factory.ConfFactory;

public class AddCoursesForStudent {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {
            session.beginTransaction();

            Integer id = 2;
            Student student = session.get(Student.class, id);

            Course course1 = new Course("Age of Empire, tactics and leadership");
            Course course2 = new Course("Tactics of scratching on the wall");

            course1.addStudents(student);
            course2.addStudents(student);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
