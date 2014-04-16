package pl.edu.agh.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public abstract class BaseHibernateRepository {

    private SessionFactory sessionFactory;

    public BaseHibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
