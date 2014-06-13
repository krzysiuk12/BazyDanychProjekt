package pl.edu.agh.tutorial.performanceTest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.Customer;
import java.util.List;

/**
 * Created by Krzysiu on 2014-06-03.
 */
public class InheritancePerformanceTest extends BaseHibernateRepository {

    public InheritancePerformanceTest(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional
    public List<Customer> testInheritanceCriteria() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }

    @Transactional
    public List<Customer> testInheritanceHQL() {
        Query query = getSession().createQuery("from Customer");
        return query.list();
    }

    @Transactional
    public List<Customer> testInheritanceNamedQueries() {
        Query query = getSession().getNamedQuery("testSingleTableInheritanceNamedQuery");
        return query.list();
    }
}
