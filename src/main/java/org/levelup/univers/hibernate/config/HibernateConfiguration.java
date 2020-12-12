package org.levelup.univers.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateConfiguration {

    private HibernateConfiguration() {}

    private static SessionFactory factory = initializeSessionFactory();

    private static SessionFactory initializeSessionFactory() {
        Configuration configuration = new Configuration()
                .configure();
        return configuration.buildSessionFactory();
    }

    // Служит для получения объекта SessionFactory
    public static SessionFactory getFactory() {
        return factory;
    }

}
