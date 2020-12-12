package org.levelup.univers.hibernate;

import org.hibernate.SessionFactory;
import org.levelup.univers.hibernate.config.HibernateConfiguration;

public class App {

    public static void main(String[] args) {
        SessionFactory factory = HibernateConfiguration.getFactory();


        factory.close();
    }

}
