package pl.edu.agh.tutorial.queries.criteriaapi.repositories;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Property;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Krzysiu on 2014-05-13.
 */
public class RestrictionsCriteriaApi extends BaseHibernateRepository {

    public RestrictionsCriteriaApi(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    /**
     * String Comparisons - like and ilike (case-insensitive like)
     *  - do pokazania 1 i 2 - w 2 powinno się dodać La maison dAsie, a w 1 nie powinno tego być
     */
    @Transactional(readOnly = true)
    public List<Company> getCompaniesWithNameRestriction() {
        Criteria criteria = getSession().createCriteria(Company.class);
        criteria.add(Restrictions.like("companyName", "LA%")); //1
        createDescription("getCompaniesWithNameRestriction - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Company.class);
        criteria.add(Restrictions.ilike("companyName", "LA%")); //2
        createDescription("getCompaniesWithNameRestriction - CRITERIA 2", criteria.list());
        return criteria.list();
    }


    /**
     * MatchMode test ;) Domyślisz się ;)
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Company> getCompaniesWithNameRestrictionMatchModes() {
        Criteria criteria = getSession().createCriteria(Company.class);
        criteria.add(Restrictions.like("companyName", "Li", MatchMode.START)); //wszystkie z LI zaczynają się od LI więc nie będzie nic bo jest case-sensitive
        createDescription("getCompaniesWithNameRestrictionMatchModes - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Company.class);
        criteria.add(Restrictions.ilike("companyName", "Li", MatchMode.START));
        createDescription("getCompaniesWithNameRestrictionMatchModes - CRITERIA 2", criteria.list());

        criteria = getSession().createCriteria(Company.class);
        criteria.add(Restrictions.like("companyName", "mercado", MatchMode.END));
        createDescription("getCompaniesWithNameRestrictionMatchModes - CRITERIA 3", criteria.list());

        criteria = getSession().createCriteria(Company.class);
        criteria.add(Restrictions.like("companyName", "A-Super", MatchMode.ANYWHERE));
        createDescription("getCompaniesWithNameRestrictionMatchModes - CRITERIA 4", criteria.list());

        criteria = getSession().createCriteria(Company.class);
        criteria.add(Restrictions.ilike("companyName", "A-SUPER", MatchMode.ANYWHERE));
        createDescription("getCompaniesWithNameRestrictionMatchModes - CRITERIA 5", criteria.list());

        criteria = getSession().createCriteria(Company.class);
        criteria.add(Restrictions.like("companyName", "LILA-Supermercado", MatchMode.EXACT));
        createDescription("getCompaniesWithNameRestrictionMatchModes- CRITERIA 6", criteria.list());

        return criteria.list();
    }

    /**
     * To samo zapytanie z IN Restriction, są dwie takie metody in(String propertyName, Collection values),
     * in(String propertyName, Object[] values).
     *
     * To jak użyjemy np Set to jest zapewnienie że nigdy nie damy dwóch "Juan".
     *
     * Każde Criteria to jest tak naprawdę to samo - muszą zwrócić te same dane i taką samą ilość.
     * @return
     */
    @Transactional(readOnly = true)
    public void getIndividualsWithInRestriction() {
        Criteria criteria = getSession().createCriteria(Individual.class);
        criteria.add(Restrictions.in("firstName", new String[]{"Juan", "David", "Brian"}));
        createDescription("getIndividualsWithInRestriction - CRITERIA", criteria.list());

        Criteria criteria2 = getSession().createCriteria(Individual.class);
        criteria2.add(Restrictions.in("firstName", new ArrayList<String>(Arrays.asList("Juan", "David", "Brian"))));
        createDescription("getIndividualsWithInRestriction - CRITERIA 2", criteria2.list());

        Criteria criteria3 = getSession().createCriteria(Individual.class);
        criteria3.add(Restrictions.in("firstName", new ArrayList<String>(Arrays.asList("Juan", "Juan", "Juan", "David", "Brian"))));
        createDescription("getIndividualsWithInRestriction - CRITERIA 3", criteria3.list());

        Criteria criteria4 = getSession().createCriteria(Individual.class);
        criteria4.add(Restrictions.in("firstName", new HashSet<String>(Arrays.asList("Juan", "David", "Brian"))));
        createDescription("getIndividualsWithInRestriction - CRITERIA 4", criteria4.list());
    }

    @Transactional(readOnly = true)
    public void getProductsWithNumberRestrictions() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.between("unitPrice", 15.0, 25.0));
        createDescription("getProductsWithNumberRestrictions - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.le("unitPrice", 15.0));
        createDescription("getProductsWithNumberRestrictions - CRITERIA 2", criteria.list());

        criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.lt("unitPrice", 15.0));
        createDescription("getProductsWithNumberRestrictions - CRITERIA 3", criteria.list());

        criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.ge("unitPrice", 15.0));
        createDescription("getProductsWithNumberRestrictions - CRITERIA 4", criteria.list());

        criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.gt("unitPrice", 15.0));
        createDescription("getProductsWithNumberRestrictions - CRITERIA 5", criteria.list());
    }

    @Transactional(readOnly = true)
    public void getOrdersWithNullRestrictions() {
        Criteria criteria = getSession().createCriteria(Order.class);
        criteria.add(Restrictions.isNotNull("shippedDate"));
        createDescription("getOrdersWithNullRestrictions - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Order.class);
        criteria.add(Restrictions.isNull("shippedDate"));
        createDescription("getOrdersWithNullRestrictions - CRITERIA 2", criteria.list());
    }

    @Transactional(readOnly = true)
    public void getOrdersWithOrderDetailsCollectionRestrictions() {
        Criteria criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.add(Restrictions.sizeLe("orderDetails", 5));
        createDescription("getOrdersWithOrderDetailsCollectionRestrictions - CRITERIA 2", criteria.list());

        criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.add(Restrictions.sizeGt("orderDetails", 5));
        createDescription("getOrdersWithOrderDetailsCollectionRestrictions - CRITERIA 2", criteria.list());

        criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.add(Restrictions.sizeEq("orderDetails", 1));
        createDescription("getOrdersWithOrderDetailsCollectionRestrictions - CRITERIA 3", criteria.list());

        criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.add(Restrictions.sizeNe("orderDetails", 5));
        createDescription("getOrdersWithOrderDetailsCollectionRestrictions - CRITERIA 4", criteria.list());

        criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.add(Restrictions.isEmpty("orderDetails"));
        createDescription("getOrdersWithOrderDetailsCollectionRestrictions - CRITERIA 5", criteria.list());

        criteria = getSession().createCriteria(Order.class);
        criteria.setFetchMode("orderDetails", FetchMode.JOIN);
        criteria.add(Restrictions.isNotEmpty("orderDetails"));
        createDescription("getOrdersWithOrderDetailsCollectionRestrictions - CRITERIA 6", criteria.list());
    }

    @Transactional(readOnly = true)
    public void getProductCombinedRestrictions() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.and(Restrictions.gt("unitPrice", 15.0), Restrictions.le("unitPrice", 25.0)));
        createDescription("getProductCombinedRestrictions - CRITERIA", criteria.list());

        criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.or(Restrictions.gt("unitPrice", 25.0), Restrictions.le("unitPrice", 15.0)));
        createDescription("getProductCombinedRestrictions - CRITERIA 2", criteria.list());

        criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.not(Restrictions.gt("unitPrice", 15.0)));
        createDescription("getProductCombinedRestrictions - CRITERIA 3", criteria.list());

        //DISJUNCTION == OR
        criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.disjunction()
                        .add(Restrictions.gt("unitPrice", 25.0))
                        .add(Restrictions.le("unitPrice", 15.0)));
        createDescription("getProductCombinedRestrictions - CRITERIA 4", criteria.list());

        //CONJUNCTION == AND
        criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.conjunction()
                        .add(Restrictions.gt("unitPrice", 15.0))
                        .add(Restrictions.le("unitPrice", 25.0)));
        createDescription("getProductCombinedRestrictions - CRITERIA 5", criteria.list());
    }

    private void createDescription(String label, List<?> list) {
        System.out.println(label + ": " + list.size() + "\n" + label + ": " + list);
    }

/*    @Transactional(readOnly = true)
    public*/
}
