package pl.edu.agh.repository;

import org.hibernate.SessionFactory;
import pl.edu.agh.domain.Category;
import pl.edu.agh.domain.Product;
import pl.edu.agh.domain.Supplier;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.repository.interfaces.IDataGeneratorRepository;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class DataGeneratorRepository extends BaseHibernateRepository implements IDataGeneratorRepository {

    public DataGeneratorRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Long saveCategory(Category category) {
        return (Long) getSession().save(category);
    }

    @Override
    public Long saveSupplier(Supplier supplier) {
        return (Long) getSession().save(supplier);
    }

    @Override
    public Long saveProduct(Product product) {
        return (Long) getSession().save(product);
    }
}
