package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.entity.Review;
import ru.kdv.hibernate.entity.Student;
import ru.kdv.hibernate.factory.ConfFactory;

public class CreateCourseAndStudent {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {

            session.beginTransaction();

            Course course = new Course("Vim - how to escape");

            session.save(course);

            Student student1 = new Student("John", "Mitchel", "JoMit@ya.ru");
            Student student2 = new Student("Mary", "Zalcman", "MaZal@ya.ru");

            course.addStudents(student1);
            course.addStudents(student2);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
