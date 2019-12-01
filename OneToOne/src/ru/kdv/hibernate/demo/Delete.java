package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.Instructor;
import ru.kdv.hibernate.entity.InstructorDetail;
import ru.kdv.hibernate.factory.ConfFactory;

public class Delete {
    public static void main(String[] args) {
        Session session = ConfFactory.getCurrentSession();
        try {
            session.beginTransaction();
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Instructor " + instructor);
            if (instructor != null) {
                session.delete(instructor);
            }
            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            ConfFactory.closeCurrentSession();
        }
    }
}
