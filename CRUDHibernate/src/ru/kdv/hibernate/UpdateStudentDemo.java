package ru.kdv.hibernate;


import org.hibernate.Session;
import ru.kdv.hibernate.entity.Student;
import ru.kdv.hibernate.factory.ConfFactory;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        Session session = ConfFactory.getCurrentSession();
        try {
            int studentId = 3;

            session.beginTransaction();

            System.out.println("Student with id: " + studentId);
            Student student = session.get(Student.class, studentId);

            System.out.println("Updating student: ");
            student.setFirstName("Updated field");

            session.createQuery("update Student set email='updatedEmail@aa.de'")
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            ConfFactory.closeCurrentSession();
        }
    }
}
