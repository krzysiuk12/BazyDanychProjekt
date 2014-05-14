package pl.edu.agh.tutorial.queries.namedqueries;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.repository.BaseHibernateRepository;

import java.util.List;

/**
 * Created by Krzysiu on 2014-05-14.
 */
public class NamedQueriesExamples extends BaseHibernateRepository {

    public NamedQueriesExamples(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional(readOnly = true)
    public void findAllProductsNamedQuery() {
        Query query = getSession().getNamedQuery("findAllProducts");
        createDescription("Named Queries - findAllProducts", query.list());
    }

    @Transactional(readOnly = true)
    public void findAllProductsWithUnitStockBetweenNamedQuery() {
        Query query = getSession().getNamedQuery("findAllProductsWithUnitStockBetween");
        query.setParameter("mininum", 15);
        query.setFloat("maximum", 25);
        createDescription("Named Queries - findAllProductsWithUnitStockBetween", query.list());
    }

    @Transactional(readOnly = true)
    public void findAllProductsWithCategoryNamedQuery() {
        Query query = getSession().getNamedQuery("findAllProductsWithCategory");
        query.setString("categoryName", "Beverages");
        createDescription("Named Queries - findAllProductsWithCategory", query.list());
    }

    @Transactional(readOnly = true)
    public void findAllProductsSQLNamedQuery() {
        Query query = getSession().getNamedQuery("findAllProductsSQL");
        query.setLong("id", 5);
        createDescription("Named Queries - findAllProductsSQLNamedQuery", query.list());
    }

    @Transactional(readOnly = true)
    public void findAllProductsAnnotationsNamedQuery() {
        Query query = getSession().getNamedQuery("findAllProductsAnnotations");
        createDescription("Named Queries - findAllProductsAnnotationsNamedQuery", query.list());
    }

    @Transactional(readOnly = true)
    public void findAllProductsWithCategoryAnootationsNamedQuery() {
        Query query = getSession().getNamedQuery("findAllProductsWithCategoryAnnotations");
        query.setString("categoryName", "Beverages");
        createDescription("Named Queries - findAllProductsWithCategoryAnootationsNamedQuery", query.list());
    }

    @Transactional(readOnly = true)
    public void findAllProductsWithUnitStockBetweenAnnotationsNamedQuery() {
        Query query = getSession().getNamedQuery("findAllProductsWithUnitsInStockBetweenAnnotations");
        query.setParameter("mininum", 15);
        query.setFloat("maximum", 25);
        createDescription("Named Queries - findAllProductsWithUnitStockBetweenAnnotationsNamedQuery", query.list());
    }

    private void createDescription(String label, List<?> list) {
        System.out.println(label + ": " + list.size() + "\n" + label + ": " + list);
    }
}
