package ru.kdv.hibernate.demo;

import org.hibernate.Session;
import ru.kdv.hibernate.entity.InstructorDetail;
import ru.kdv.hibernate.factory.ConfFactory;

public class DeleteInstrucrorDetail {
    public static void main(String[] args) {
        Session session = ConfFactory.getCurrentSession();
        try {
            session.beginTransaction();
            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor detail:" + instructorDetail);
            System.out.println("Associated instructor:" + instructorDetail.getInstructor());
            System.out.println("delete instrucrtor detail: ");
            //If we want to delete only InstructorDetail without instructor, we should
            //break relation between two tables.
            //instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);
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
