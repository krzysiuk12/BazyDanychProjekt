package pl.edu.agh.repository.criteriaapi;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.ResultSetSupportingSqlParameter;
import pl.edu.agh.domain.*;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.repository.interfaces.IWarehouseRepository;

import java.util.List;
import java.util.concurrent.CyclicBarrier;

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

    @Override
    public List<Customer> getAllCustomers() {
        return getSession().createCriteria(Customer.class).list();
    }

    @Override
    public List<Region> getAllRegions() {
        return getSession().createCriteria(Region.class).list();
    }

    @Override
    public List<Territory> getAllTerritories() {
        return getSession().createCriteria(Territory.class).list();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return getSession().createCriteria(Employee.class).list();
    }

    @Override
    public List<Shipper> getAllShippers() {
        return getSession().createCriteria(Shipper.class).list();
    }

    @Override
    public List<Order> getAllOrders() {
        return getSession().createCriteria(Order.class).list();
    }


}
