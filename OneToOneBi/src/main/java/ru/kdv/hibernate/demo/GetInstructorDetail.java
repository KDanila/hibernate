package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.InstructorDetail;
import ru.kdv.hibernate.factory.ConfFactory;

public class GetInstructorDetail {
    public static void main(String[] args) {
        Session session = ConfFactory.getCurrentSession();
        try {
            session.beginTransaction();
            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor detail:" + instructorDetail);
            System.out.println("Associated instructor:" + instructorDetail.getInstructor());
            session.getTransaction().commit();
            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            ConfFactory.closeCurrentSession();
        }
    }
}
