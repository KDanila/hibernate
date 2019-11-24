package ru.kdv.hibernate.factory;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kdv.hibernate.entity.Student;

public class ConfFactory {
    private static SessionFactory factory;

    public static synchronized Session getCurrentSession(){
        initFactory();
        return factory.getCurrentSession();
    }

    private static void initFactory() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public static synchronized void closeCurrentSession(){
        factory.close();
    }
}
