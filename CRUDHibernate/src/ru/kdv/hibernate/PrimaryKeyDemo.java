package ru.kdv.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kdv.hibernate.entity.Student;


public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            System.out.println("create new students");
            Student student0 = new Student("Paul", "Wall", "PaulWall@ya.ru");
            Student student1 = new Student("Mary", "Laurense", "MLaurense@ya.ru");
            Student student2 = new Student("Georg", "V", "GeorgeV@ya.ru");
            //Start transaction
            session.beginTransaction();
            //Save the student
            session.save(student0);
            session.save(student1);
            session.save(student2);
            //Commit
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
