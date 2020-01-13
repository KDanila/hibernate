package hibernate.demo;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.factory.ConfFactory;
import org.hibernate.Session;

import java.util.List;

public class EagerLazy {
    public static void main(String[] args) {
        ConfFactory cf = new ConfFactory();
        Session session = cf.getCurrentSession();
        try {
            session.beginTransaction();
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            List<Course> courses = instructor.getCourses();

            System.out.println(courses);

            session.getTransaction().commit();

        } finally {
            cf.closeCurrentSession();
        }
    }
}
