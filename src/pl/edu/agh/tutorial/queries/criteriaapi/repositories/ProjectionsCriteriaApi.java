package pl.edu.agh.tutorial.queries.criteriaapi.repositories;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.Product;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Krzysiu on 2014-05-13.
 */
public class ProjectionsCriteriaApi extends BaseHibernateRepository {

    public ProjectionsCriteriaApi(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional(readOnly = true)
         public void rowCountProjection() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.setProjection(Projections.rowCount());
        //criteria.uniqueResult();
        createDescription("rowCountProjection - CRITERIA", criteria.list());
    }

    @Transactional(readOnly = true) //Returns array of objects not single value
    public void aggregationFunctionsProjections() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.rowCount())
                .add(Projections.avg("unitPrice"), "avgUnitPrice")
                .add(Projections.countDistinct("productName").as("countDistinctProductName"))
                .add(Projections.count("productName"))
                .add(Projections.max("unitPrice"))
                .add(Projections.min("unitPrice"))
                .add(Projections.sum("unitPrice")));
        for(Object object : (Object[])criteria.list().get(0)) {
            System.out.println(object);
        }
        createDescription("rowCountProjection - CRITERIA", criteria.list());
    }

    @Transactional(readOnly = true) //group by
    public void groupByProjections() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.createAlias("category", "category");
        criteria.setProjection(Projections.projectionList()
                .add(Projections.groupProperty("category.categoryName"))
                .add(Projections.count("productName")));
        createDescription("rowCountProjection - CRITERIA", criteria.list());
    }


    private void createDescription(String label, List<?> list) {
        System.out.println(label + ": " + list.size() + "\n" + label + ": " + list);
    }
}
