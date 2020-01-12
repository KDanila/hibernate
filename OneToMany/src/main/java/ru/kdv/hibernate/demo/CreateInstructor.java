package main.java.ru.kdv.hibernate.demo;

import main.java.ru.kdv.hibernate.entity.Instructor;
import main.java.ru.kdv.hibernate.entity.InstructorDetail;
import main.java.ru.kdv.hibernate.factory.ConfFactory;
import org.hibernate.Session;

public class CreateInstructor {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {
            Instructor instructor = new Instructor("Egor", "Agrhhh", "EgorAgrhh@ya.ru");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/nothing", "Programing");

            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            System.out.println("Saving instructor " + instructor);
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            cf.closeCurrentSession();
        }
    }
}
