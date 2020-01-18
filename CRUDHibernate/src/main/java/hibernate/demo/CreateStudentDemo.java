package hibernate.demo;

import hibernate.entity.Student;
import hibernate.factory.ConfFactory;
import org.hibernate.Session;

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
