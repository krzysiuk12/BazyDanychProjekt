package pl.edu.agh.tutorial.performanceTest;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.Product;

import java.util.List;

/**
 * Created by Krzysiu on 2014-06-03.
 */
public class SelectPerformanceTest extends BaseHibernateRepository {

    public SelectPerformanceTest(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional
    public List<Product> getAllProductsFetchWithCriteria() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.setFetchMode("category", FetchMode.JOIN);
        criteria.setFetchMode("supplier", FetchMode.JOIN);
        List<Product> products = criteria.list();
        return products;
    }

    @Transactional
    public List<Product> getAllProductsNoFetchWithCriteria() {
        Criteria criteria = getSession().createCriteria(Product.class);
        List<Product> products = criteria.list();
        return products;
    }

    @Transactional
    public List<Product> getAllProductsFetchWithHQL() {
        Query query = getSession().createQuery("from Product as product inner join fetch product.category inner join fetch product.supplier");
        return query.list();
    }

    @Transactional
    public List<Product> getAllProductsNoFetchWithHQL() {
        Query query = getSession().createQuery("from Product as product");
        return query.list();
    }

    @Transactional
    public List<Product> getAllProductsFetchNamedQueries() {
        Query query = getSession().getNamedQuery("getAllProductsFetchNamedQuery");
        return query.list();
    }

    @Transactional
    public List<Product> getAllProductsNoFetchNamedQueries() {
        Query query = getSession().getNamedQuery("getAllProductsNoFetchNamedQuery");
        return query.list();
    }

}
