package pl.edu.agh.tutorial.performanceTest;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.Order;

import java.util.List;

/**
 * Created by Krzysiu on 2014-06-12.
 */
public class ComplexQueriesTest extends BaseHibernateRepository {

    public ComplexQueriesTest(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /*
    Zapytanie zwraca zamówienia, w których dostawcy produktów pochodzą z UK, cena jednostkowa
     produtku jest większa niż 20, ale mniejsza niż 25. Produkty mają być z kategorii Confections.
     */
    @Transactional(readOnly = true)
    public List<Order> getOrders() {
        Criteria criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.createAlias("orderDetails.product", "product");
        criteria.createAlias("product.supplier", "supplier");
        criteria.createAlias("supplier.address", "address");
        criteria.createAlias("product.category", "category");
        criteria.add(Restrictions.eq("address.country", "UK"));
        criteria.add(Restrictions.ge("product.unitPrice", 20.0f));
        criteria.add(Restrictions.le("product.unitPrice", 25.0f));
        criteria.add(Restrictions.eq("category.categoryName", "Confections"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Order> list = criteria.list();
        return list;
    }

    /* Pobierz zamówienia gdzie dostawca produktu znajduje się w UK oraz
        klient znajduje się w UK i w zamówieniu jest produkt z kategorii Confections
     */
    @Transactional(readOnly = true)
         public List<Order> getOrdersWithCustomer() {
        Criteria criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.createAlias("orderDetails.product", "product");
        criteria.createAlias("product.supplier", "supplier");
        criteria.createAlias("supplier.address", "address");
        criteria.createAlias("product.category", "category");
        criteria.createAlias("customer", "customer");
        criteria.createAlias("customer.address", "customerAddress");
        criteria.add(Restrictions.eq("customerAddress.country", "UK"));
        criteria.add(Restrictions.eq("address.country", "UK"));
        criteria.add(Restrictions.eq("category.categoryName", "Confections"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Order> list = criteria.list();
        return list;
    }

    /**
     * Pobierz zamówienia wykonane przez Mary Thomas
     * @return
     */
    @Transactional(readOnly = true)
    public List<Order> getOrdersWithCustomerName() {
        Criteria criteria = getSession().createCriteria(Order.class, "order");
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.createAlias("orderDetails.product", "product");
        criteria.createAlias("product.supplier", "supplier");
        criteria.createAlias("supplier.address", "address");
        criteria.createAlias("product.category", "category");
        criteria.createAlias("customer", "customer");
        criteria.add(Restrictions.eq("customer.firstName", "Mary"));
        criteria.add(Restrictions.eq("customer.lastName", "Thomas"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Order> list = criteria.list();
        return list;
    }

    /**
     * Zlicz ilość produktów w poszczególnych zamówieniach wykonanych przez firmę Piccolo und mehr
     * @return
     */
    @Transactional(readOnly = true)
    public void getNumberOfOrdersHQL() {
        Query query = getSession().createQuery("select ord.id, count(details.id) from Order ord inner join ord.orderDetails details inner join ord.customer cust where cust.companyName = 'Piccolo und mehr' group by ord.id");
        List list = query.list();
        System.out.println("Size: " + list.size());
    }

    @Transactional(readOnly = true)
    public void getNumberOfOrdersNamedQuery() {
        Query query = getSession().getNamedQuery("getNumberOfOrdersNamedQuery");
        List list = query.list();
        System.out.println("Size: " + list.size());
    }

    /**
     * Zlicz ilość różnych kategorii produktów dla każdego zamówienia dla klienta Piccolo und mehr
     * @return
     */
    @Transactional(readOnly = true)
    public void getNumberOfCategoriesHQL() {
        Query query = getSession().createQuery("select ord.id, count(distinct cat.id) from Order ord inner join ord.orderDetails details inner join details.product prod inner join prod.category cat inner join ord.customer cust where cust.companyName = 'Piccolo und mehr' group by ord.id");
        List list = query.list();
        System.out.println("Size: " + list.size());
    }

    @Transactional(readOnly = true)
    public void getNumberOfCategoriesNamedQueries() {
        Query query = getSession().getNamedQuery("getNumberOfCategoriesNamedQuery");
        List list = query.list();
        System.out.println("Size: " + list.size());
    }

    /**
     * Zlicz ilość kategorii produktów dostarczanych przez każdego dostawcę
     * @return
     */
    @Transactional(readOnly = true)
    public void getNumberOfProductsBySupplierHQL() {
        Query query = getSession().createQuery("select sup.companyName, count(distinct cat.id), count(prod.id) from Supplier sup inner join sup.suppliedProducts prod inner join prod.category cat group by sup.companyName");
        List list = query.list();
        System.out.println("Size: " + list.size());
    }

    @Transactional(readOnly = true)
    public void getNumberOfProductsBySupplierNamedQueries() {
        Query query = getSession().getNamedQuery("getNumberOfProductsBySupplierNamedQuery");
        List list = query.list();
        System.out.println("Size: " + list.size());
    }
}
