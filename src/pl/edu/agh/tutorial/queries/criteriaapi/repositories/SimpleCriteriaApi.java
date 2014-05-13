package pl.edu.agh.tutorial.queries.criteriaapi.repositories;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.ResultTransformer;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.tutorial.domain.*;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.Order;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Krzysiu on 2014-05-07.
 */
public class SimpleCriteriaApi extends BaseHibernateRepository {

    public SimpleCriteriaApi(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Prosta metoda to uzyskiwania wszystkich produktów i wszystkich danych z nich.
     *
     * @return
     */
    @Transactional
    public List<Product> getAllProducts() {
        return getSession().createCriteria(Product.class).list();
    }

    @Transactional
    public void getCompaniesWithCriteriaOrdering() {
        Criteria criteria = getSession().createCriteria(Company.class);
        criteria.addOrder(org.hibernate.criterion.Order.asc("companyName"));
        createDescription("getCompaniesWithCriteriaOrdering - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Company.class);
        criteria.addOrder(Property.forName("companyName").asc());
        createDescription("getCompaniesWithCriteriaOrdering - CRITERIA 2", criteria.list());

        criteria = getSession().createCriteria(Company.class);
        criteria.addOrder(org.hibernate.criterion.Order.desc("companyName"));
        createDescription("getCompaniesWithCriteriaOrdering - CRITERIA 3", criteria.list());

        criteria = getSession().createCriteria(Company.class);
        criteria.addOrder(Property.forName("companyName").desc());
        createDescription("getCompaniesWithCriteriaOrdering - CRITERIA 4", criteria.list());
    }

    @Transactional(readOnly = true)
    public void getCompaniesTypesOfResult() {
        Criteria criteria = getSession().createCriteria(Company.class); //LIST + MAX RESULTS
        criteria.setMaxResults(20);
        createDescription("getCompaniesWithCriteriaOrdering - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Company.class); //UNIQUE RESULT - if not unique then exception
        Company company = (Company)criteria.add(Restrictions.eq("id", 1)).uniqueResult();
        createDescription("getCompaniesWithCriteriaOrdering - CRITERIA", Arrays.asList(company));
    }

    @Transactional(readOnly = true)
    public void getOrdersFetchModes() {
        Criteria criteria = getSession().createCriteria(Order.class); //ILOCZYN KARTEZJANSKI
        criteria.createAlias("orderDetails", "oD");
        createDescription("getOrdersFetchModes - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Order.class);    //ILOCZYN KARTEZJANSKI
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        createDescription("getOrdersFetchModes - CRITERIA 2", criteria.list());

        criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.SELECT);
        createDescription("getOrdersFetchModes - CRITERIA 3", criteria.list());

        criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.DEFAULT);
        createDescription("getOrdersFetchModes - CRITERIA 4", criteria.list());
    }

    @Transactional(readOnly = true)
    public void getOrdersWithResultTransformers() {
        Criteria criteria = getSession().createCriteria(Order.class); //Pobiera orderDetails tak naprawdę jeszcze więc będzie ponad 1000
        criteria.createAlias("orderDetails", "oD");
        criteria.createAlias("oD.product", "product");
        criteria.createAlias("product.supplier", "supplier");
        createDescription("getOrdersWithResultTransformers - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Order.class); //wszystko jest "ściągane" do obiektów order - BARDZO PRZYDANE tak na przyszłośc
        criteria.createAlias("orderDetails", "oD");
        criteria.createAlias("oD.product", "product");
        criteria.createAlias("product.supplier", "supplier");
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        createDescription("getOrdersWithResultTransformers - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Order.class); //DOSTAJEMY MAPĘ Obiektów, gdzie jedno ENTRY to jest taka kombinacja: Product - OrderDetails - Order - Supplier
        criteria.createAlias("orderDetails", "oD");
        criteria.createAlias("oD.product", "product");
        criteria.createAlias("product.supplier", "supplier");
        criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<Object> list = criteria.list();
/*        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            Map map = (Map)iterator.next();
            System.out.println(map);
            Order order = (Order) map.get(Criteria.ROOT_ALIAS);
            System.out.println(order);
            //Order order = iterator
        }*/
        System.out.println(list.size());
    }

    @Transactional
    public void cartesianProductProblem2Collections() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.setFetchMode("orders", FetchMode.JOIN);
        criteria.setFetchMode("orders.orderDetails", FetchMode.JOIN);
        createDescription("getOrdersWithResultTransformers - CRITERIA", criteria.list());
    }

    private void createDescription(String label, List<?> list) {
        System.out.println(label + ": " + list.size() + "\n" + label + ": " + list);
    }
}
