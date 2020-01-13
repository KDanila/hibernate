package hibernate.factory;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfFactory {
    private SessionFactory factory;

    public synchronized Session getCurrentSession() {
        if (factory == null) {
            initFactory();
        }
        return this.factory.openSession();
    }

    private void initFactory() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    public synchronized void closeCurrentSession() {
        this.factory.close();
    }
}
