package helloworld;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import pl.edu.agh.domain.Categories;
import pl.edu.agh.domain.Shippers;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Krzysiu on 2014-04-02.
 */
public class HelloWorld {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder srb = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(srb.buildServiceRegistry());
        Session session = sf.openSession();
        session.getTransaction().begin();
        List<Shippers> shippers = session.createQuery("from Shippers ").list();
        for(Shippers shipper : shippers) {
            System.out.println(shipper);
        }
        session.getTransaction().commit();

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("northwind");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        List<Categories> result = entityManager.createQuery( "from Categories ", Categories.class ).getResultList();
//        for ( Categories category : result ) {
//            System.out.println(category);
//        }
//        entityManager.getTransaction().commit();
//        entityManager.close();
    }
}
