package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Instructor;
import ru.kdv.hibernate.entity.InstructorDetail;
import ru.kdv.hibernate.factory.ConfFactory;

public class Create {
    public static void main(String[] args) {
        Session session = ConfFactory.getCurrentSession();
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
            ConfFactory.closeCurrentSession();
        }
    }
}
