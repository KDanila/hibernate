package ru.kdv.hibernate.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.entity.Instructor;
import ru.kdv.hibernate.entity.InstructorDetail;
import ru.kdv.hibernate.entity.Review;

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
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
    }

    public synchronized void closeCurrentSession() {
        this.factory.close();
    }
}
