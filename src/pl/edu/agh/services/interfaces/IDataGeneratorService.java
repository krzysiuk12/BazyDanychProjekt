package pl.edu.agh.services.interfaces;

import pl.edu.agh.domain.*;

import java.util.List;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public interface IDataGeneratorService {

    public List<Category> generateCategories();

    public List<Supplier> generateSuppliers();

    public List<Product> generateProducts(List<Category> categories, List<Supplier> supplier);

    public List<Customer> generateCustomers();

    public List<Region> generateRegions();

    public List<Territory> generateTerritories(List<Region> regions);

    public List<Employee> generateEmployees();

    public List<Shipper> generateShippers();

    public List<Order> generateOrders(List<Customer> customers, List<Employee> employees, List<Shipper> shippers);

}
