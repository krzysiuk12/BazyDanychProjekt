package pl.edu.agh.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.agh.domain.*;
import pl.edu.agh.services.interfaces.IDataGeneratorService;
import pl.edu.agh.services.interfaces.IWarehouseService;

import java.util.List;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class NorthwindTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        IDataGeneratorService dataGeneratorService = ((IDataGeneratorService)context.getBean("dataGeneratorService"));
        List<Category> categories = dataGeneratorService.generateCategories();
        List<Supplier> suppliers = dataGeneratorService.generateSuppliers();
        dataGeneratorService.generateProducts(categories, suppliers);
        List<Customer> customers = dataGeneratorService.generateCustomers();
        List<Region> regions = dataGeneratorService.generateRegions();
        List<Territory> territories = dataGeneratorService.generateTerritories(regions);
        List<Employee> employees = dataGeneratorService.generateEmployees();
        List<Shipper> shippers = dataGeneratorService.generateShippers();
        List<Order> orders = dataGeneratorService.generateOrders(customers, employees, shippers);

        IWarehouseService warehouseService = ((IWarehouseService)context.getBean("warehouseService"));
        System.out.println(warehouseService.getAllCategories());
        System.out.println(warehouseService.getAllSuppliers());
        System.out.println(warehouseService.getAllProducts());
        System.out.println(warehouseService.getAllCustomers());
        System.out.println(warehouseService.getAllRegions());
        System.out.println(warehouseService.getAllTerritories());
       // System.out.println(warehouseService.getAllEmployees());
        System.out.println(warehouseService.getAllShippers());

        System.out.println(warehouseService.getAllOrders());
    }

}
