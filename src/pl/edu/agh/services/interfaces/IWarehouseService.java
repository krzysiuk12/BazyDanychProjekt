package pl.edu.agh.services.interfaces;

import pl.edu.agh.domain.*;

import java.util.List;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public interface IWarehouseService {

    List<Category> getAllCategories();

    List<Supplier> getAllSuppliers();

    List<Product> getAllProducts();

    List<Customer> getAllCustomers();

    List<Region> getAllRegions();

    List<Territory> getAllTerritories();

    List<Employee> getAllEmployees();

    List<Shipper> getAllShippers();

    List<Order> getAllOrders();
}
