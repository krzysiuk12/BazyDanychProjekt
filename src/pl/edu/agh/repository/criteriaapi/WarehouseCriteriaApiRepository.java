package pl.edu.agh.repository.criteriaapi;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.ResultSetSupportingSqlParameter;
import pl.edu.agh.domain.Category;
import pl.edu.agh.domain.Product;
import pl.edu.agh.domain.Supplier;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.repository.interfaces.IWarehouseRepository;

import java.util.List;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class WarehouseCriteriaApiRepository extends BaseHibernateRepository implements IWarehouseRepository {

    public WarehouseCriteriaApiRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Category> getAllCategories() {
        return getSession().createCriteria(Category.class).list();
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return getSession().createCriteria(Supplier.class).list();
    }

    @Override
    public List<Product> getAllProducts() {
        return getSession().createCriteria(Product.class).list();
    }
}
