package hibernate.demo;

import hibernate.entity.Student;
import hibernate.factory.ConfFactory;
import org.hibernate.Session;

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
