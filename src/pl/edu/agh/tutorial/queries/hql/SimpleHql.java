package pl.edu.agh.tutorial.queries.hql;

import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Krzysiu on 2014-05-14.
 */
public class SimpleHql extends BaseHibernateRepository {

    public SimpleHql(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return getSession().createQuery("from Product").list();
    }

    @Transactional(readOnly = true)
    public void projectionsInSelectClause() {
        List<Product> products = getSession().createQuery("select productName, unitPrice, quantityPerUnit from Product").list();

        // Jak podajemy join na inną tabelę to trzeba wtedy zrobić alias na Product z from - inaczej błąd
        List<Product> productsWithCategories = getSession().createQuery("select product.productName, product.unitPrice, product.quantityPerUnit, category.categoryName from Product as product inner join Category as category").list();
    }

    @Transactional(readOnly = true)
    public void associationsAndJoinsExamples() {
        //Keyword WITH - dodatkowe ograniczenia dla joina
        //WITH is not allowed with FETCH keyword
        List<Customer> customersWithOrders = getSession().createQuery("from Customer as customer inner join customer.orders as ord with ord.shipCountry = 'UK'").list();
        System.out.println(customersWithOrders.size());

        List<Customer> customersWithFetchOrders = getSession().createQuery("from Customer as customer inner join fetch customer.orders as ord where ord.shipCountry = 'UK'").list();
        System.out.println(customersWithOrders.size());

        //FETCH keyword - dociąganie obiektów - iloczyn kartezjanski - sa 2 kolekcje
        //List<Customer> customersWithOrderDetails = getSession().createQuery("from Customer as customer inner join fetch customer.orders as ord inner join fetch ord.orderDetails as orderDetail").list();
        //System.out.println(customersWithOrderDetails.size());
    }

    @Transactional(readOnly = true)
    public void hqlExpressionExamples() {
        //IN and NOT IN - operator
        List<Customer> customers = getSession().createQuery("from Individual as individual where individual.firstName in ('Juan', 'Daniel', 'Maria')").list();
        createDescription("HQL - IN Operator Test", customers);
        List<Customer> customersNotIn = getSession().createQuery("from Individual as individual where individual.firstName not in ('Juan', 'Daniel', 'Maria')").list();
        createDescription("HQL - IN Operator Test", customersNotIn);

        //IS EMPTY and IS NOT EMPTY - operator test
        List<Order> orders = getSession().createQuery("from Order as ord where ord.orderDetails is empty").list();
        createDescription("HQL - IS EMPTY Operator Test", orders);
        List<Order> ordersNotEmpty = getSession().createQuery("from Order as ord where ord.orderDetails is not empty").list();
        createDescription("HQL - IS EMPTY Operator Test", ordersNotEmpty);

        //IS NULL and IS NOT NULL - operator test
        List<Order> shippedOrders = getSession().createQuery("from Order as ord where ord.shippedDate is not null").list();
        createDescription("HQL - IS NULL Operator Test", shippedOrders);
        List<Order> notShippedOrders = getSession().createQuery("from Order as ord where ord.shippedDate is null").list();
        createDescription("HQL - IS NOT NULL Operator Test", notShippedOrders);
    }

    @Transactional(readOnly = true)
    public void dateManipulationExamples() {
        List<Object> dateObjects = getSession().createQuery("select day(ord.shippedDate), month(ord.shippedDate), year(ord.shippedDate) from Order as ord where ord.shippedDate is not null").list();
        createDescription("HQL - day(), minute(), year() Function Test", dateObjects);
    }

    @Transactional(readOnly = true)
    public void stringManipulationExamples() {
        List<String> concatenationOne = getSession().createQuery("select firstName||' '||lastName from Individual").list();
        createDescription("HQL - ...||... Concatenation Operator", concatenationOne);

        List<String> concatenationTwo = getSession().createQuery("select concat(firstName, lastName) from Individual").list();
        createDescription("HQL - concat(...) function", concatenationTwo);

        List<String> someFunctions = getSession().createQuery("select substring(firstName, 0, 2), trim(firstName), lower(firstName), upper(firstName) from Individual").list();
        createDescription("HQL - String Functions", someFunctions);
    }

    @Transactional(readOnly = true)
    public void aggregateFunctions() {
        Object[] aggregateFunctionTest = (Object[])getSession().createQuery("select count(*), count(distinct productName), count(all productName), avg(unitsInStock), sum(unitsInStock), max(unitPrice), min(unitPrice) from Product ").uniqueResult();
        createDescription("HQL - count(*), count(distinct ...), count(all ...), avg(...), sum(...), max(...), min(...)", Arrays.asList(aggregateFunctionTest));
    }

    @Transactional(readOnly = true)
    public void groupByExample() {
        List<Object> groupByExample = getSession().createQuery("select cat.categoryName, count(product.id) from Product as product inner join product.category as cat group by cat.categoryName having cat.id > 5").list();
        createDescription("HQL - Group By and Having Test", groupByExample);
    }

    private void createDescription(String label, List<?> list) {
        System.out.println(label + ": " + list.size() + "\n" + label + ": " + list);
    }
}
