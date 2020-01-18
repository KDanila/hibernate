package hibernate.demo;


import hibernate.entity.Student;
import hibernate.factory.ConfFactory;
import org.hibernate.Session;

public class ReadStudentDemo {
    public static void main(String[] args) {
        Session session = ConfFactory.getCurrentSession();

        try {
            System.out.println("create new student");
            Student student = new Student("Paul", "Wall", "PaulWall@ya.ru");
            //Start transaction
            session.beginTransaction();
            //Save the student
            System.out.println(student);
            session.save(student);
            //Commit
            session.getTransaction().commit();
            System.out.println("Generated id = " + student.getId());
            //get a new session ans start transaction
            session = ConfFactory.getCurrentSession();
            session.beginTransaction();
            //retrieve student based on the id
            Student receivedStudent = session.get(Student.class, student.getId());
            System.out.println("received :" + receivedStudent);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            ConfFactory.closeCurrentSession();
        }
    }
}
