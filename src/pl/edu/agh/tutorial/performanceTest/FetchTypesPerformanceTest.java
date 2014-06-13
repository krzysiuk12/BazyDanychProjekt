package pl.edu.agh.tutorial.performanceTest;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.Order;

import java.util.List;

/**
 * Created by Krzysiu on 2014-06-03.
 */
public class FetchTypesPerformanceTest extends BaseHibernateRepository {

    public FetchTypesPerformanceTest(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional
    public List<Order> getAllOrdersWithFetchJoin() {
        Criteria criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.setFetchMode("orderDetails.product", FetchMode.JOIN);
        criteria.setFetchMode("orderDetails.product.category", FetchMode.JOIN);
        criteria.setFetchMode("orderDetails.product.supplier", FetchMode.JOIN);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    @Transactional
    public List<Order> getAllOrdersWithFetchSelect() {
        Criteria criteria = getSession().createCriteria(Order.class);
/*        criteria.setFetchMode("orderDetails", FetchMode.SELECT);
        criteria.setFetchMode("orderDetails.product", FetchMode.SELECT);
        criteria.setFetchMode("orderDetails.product.category", FetchMode.SELECT);
        criteria.setFetchMode("orderDetails.product.supplier", FetchMode.SELECT);*/
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }
}
