package ru.kdv.hibernate;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Student;
import ru.kdv.hibernate.factory.ConfFactory;

public class CreateStudentDemo {
    public static void main(String[] args) {

        Session session = ConfFactory.getCurrentSession();
        try {
            System.out.println("create new student");
            Student student = new Student("Paul", "Wall", "PaulWall@ya.ru");
            //Start transaction
            session.beginTransaction();
            //Save the student
            session.save(student);
            //Commit
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            ConfFactory.closeCurrentSession();
        }
    }
}
