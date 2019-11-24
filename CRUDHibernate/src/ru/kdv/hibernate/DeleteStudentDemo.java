package ru.kdv.hibernate;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Student;
import ru.kdv.hibernate.factory.ConfFactory;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        Session session = ConfFactory.getCurrentSession();
        try {
            int studentId = 2;

            session.beginTransaction();

            System.out.println("Student with id: " + studentId);
            Student student = session.get(Student.class, studentId);
            System.out.println("Delete student");
            session.delete(student);

            //session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            ConfFactory.closeCurrentSession();
        }
    }

    private static void createFirstFieldInTable(Session session) {
        Student firstStudent = new Student("Paul", "Wall", "PaulWall@ya.ru");
        firstStudent.setId(1);
        session.save(firstStudent);
        session.getTransaction().commit();
    }
}
