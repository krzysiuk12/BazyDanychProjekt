package pl.edu.agh.repository;

import org.hibernate.SessionFactory;
import pl.edu.agh.domain.*;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.repository.interfaces.IDataGeneratorRepository;

import java.util.List;

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

    @Override
    public Long saveCustomer(Customer customer) {
        return (Long) getSession().save(customer);
    }

    @Override
    public Long saveRegion(Region region) {
        return  (Long) getSession().save(region);
    }

    @Override
    public Long saveTerritory(Territory territory) {
        return (Long) getSession().save(territory);
    }

    @Override
    public Long saveEmployee(Employee employee) {
        return (Long) getSession().save(employee);
    }


    @Override
    public Long saveShipper(Shipper shipper) {
        return (Long) getSession().save(shipper);
    }

    @Override
    public Long saveOrder(Order order) {
        return (Long) getSession().save(order);
    }
}
