package pl.edu.agh.tutorial.generator;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysiu on 2014-05-13.
 */
public class DataGeneratorRepository extends BaseHibernateRepository {

    private static final DataGenerator DATA_GENERATOR = new DataGenerator();
/*    private static final int COMPANIES_SIZE = 1000;
    private static final int PERSONS_SIZE = 100;
    private static final int CATEGORIES_SIZE = 500;
    private static final int PRODUCTS_SIZE = 1;
    private static final int SUPPLIERS_SIZE = 300;
    private static final int ORDERS_SIZE = 2000;*/

    private static final int COMPANIES_SIZE = 10000;
    private static final int PERSONS_SIZE = 10000;
    private static final int CATEGORIES_SIZE = 2000;
    private static final int PRODUCTS_SIZE = 150000;
    private static final int SUPPLIERS_SIZE = 10000;
    private static final int ORDERS_SIZE = 10000;


    public DataGeneratorRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional
    public void generateData() {
        List<Category> categories = DATA_GENERATOR.generateCategories(CATEGORIES_SIZE);
        saveList(categories);
        List<Supplier> suppliers = DATA_GENERATOR.generateSuppliers(SUPPLIERS_SIZE);
        saveList(suppliers);
        List<Product> products = DATA_GENERATOR.generateProducts(PRODUCTS_SIZE, categories, suppliers);
        saveList(products);
        List<Individual> individuals = DATA_GENERATOR.createIndividuals(PERSONS_SIZE);
        List<Company> companies = DATA_GENERATOR.createCompanies(COMPANIES_SIZE);
        List<Customer> customers = new ArrayList<Customer>();
        customers.addAll(companies);
        customers.addAll(individuals);
        saveList(customers);
        List<Order> orders = DATA_GENERATOR.createOrders(ORDERS_SIZE, customers, products);
        saveList(orders);
    }

    @Transactional
    private void saveList(List<?> list) {
        for(Object object : list) {
            getSession().save(object);
        }
    }

}
