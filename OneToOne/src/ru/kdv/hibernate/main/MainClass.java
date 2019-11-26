package ru.kdv.hibernate.main;

import org.hibernate.Session;
import ru.kdv.hibernate.factory.ConfFactory;

public class MainClass {
    Session session = ConfFactory.getCurrentSession();
}
