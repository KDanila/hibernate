package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.entity.Student;
import ru.kdv.hibernate.factory.ConfFactory;

public class GetCoursesForStudent {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {
            session.beginTransaction();

            Integer id = 2;
            Student student = session.get(Student.class, id);

            session.getTransaction().commit();

            System.out.println(student.getCourses());

        } finally {
            session.close();
        }
    }
}
