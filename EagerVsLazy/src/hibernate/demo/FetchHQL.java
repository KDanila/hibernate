package hibernate.demo;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.factory.ConfFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FetchHQL {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {
            session.beginTransaction();
            int id = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i " +
                    "join fetch i.courses " +
                    "where i.id=:instructorId", Instructor.class);
            query.setParameter("instructorId", id);

            Instructor instructor = query.getSingleResult();

            session.getTransaction().commit();

            session.close();

            System.out.println(instructor.getCourses());

        } finally {
            cf.closeCurrentSession();
        }
    }
}
