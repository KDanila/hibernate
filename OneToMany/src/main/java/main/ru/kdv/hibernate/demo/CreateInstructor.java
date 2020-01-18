package main.ru.kdv.hibernate.demo;

import main.ru.kdv.hibernate.factory.ConfFactory;
import main.ru.kdv.hibernate.entity.Instructor;
import org.hibernate.Session;
import main.ru.kdv.hibernate.entity.InstructorDetail;

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
