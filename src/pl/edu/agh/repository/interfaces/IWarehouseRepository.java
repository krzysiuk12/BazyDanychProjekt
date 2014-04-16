package pl.edu.agh.repository.interfaces;

import pl.edu.agh.domain.Category;
import pl.edu.agh.domain.Product;
import pl.edu.agh.domain.Supplier;

import java.util.List;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public interface IWarehouseRepository {

    List<Category> getAllCategories();

    List<Supplier> getAllSuppliers();

    List<Product> getAllProducts();

}