package pl.edu.agh.services;

import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.domain.*;
import pl.edu.agh.repository.interfaces.IWarehouseRepository;
import pl.edu.agh.services.interfaces.IWarehouseService;

import java.util.List;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class WarehouseService implements IWarehouseService {

    private IWarehouseRepository warehouseRepository;

    public WarehouseService(IWarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return warehouseRepository.getAllCategories();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Supplier> getAllSuppliers() {
        return warehouseRepository.getAllSuppliers();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return warehouseRepository.getAllProducts();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return warehouseRepository.getAllCustomers();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> getAllRegions() {
        return warehouseRepository.getAllRegions();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Territory> getAllTerritories() {
        return warehouseRepository.getAllTerritories();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return warehouseRepository.getAllEmployees();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shipper> getAllShippers() {
        return warehouseRepository.getAllShippers();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return warehouseRepository.getAllOrders();
    }

}
