package pl.edu.agh.tutorial.queries.criteriaapi.repositories;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.domain.Product;
import pl.edu.agh.repository.BaseHibernateRepository;

import java.util.List;

/**
 * Created by Krzysiu on 2014-05-07.
 */
public class SimpleCriteriaApi extends BaseHibernateRepository {

    public SimpleCriteriaApi(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return getSession().createCriteria(Product.class).list();
    }
}
