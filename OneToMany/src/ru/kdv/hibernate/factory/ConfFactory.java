package ru.kdv.hibernate.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kdv.hibernate.entity.Course;
import ru.kdv.hibernate.entity.Instructor;
import ru.kdv.hibernate.entity.InstructorDetail;

public class ConfFactory {
    private static SessionFactory factory;

    public static synchronized Session getCurrentSession() {
        initFactory();
        return factory.openSession();
    }

    private static void initFactory() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    public static synchronized void closeCurrentSession() {
        factory.close();
    }
}
