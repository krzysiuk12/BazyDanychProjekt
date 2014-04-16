package pl.edu.agh.services;

import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.domain.Category;
import pl.edu.agh.domain.Product;
import pl.edu.agh.domain.Supplier;
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
}
