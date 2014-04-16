package pl.edu.agh.services.interfaces;

import pl.edu.agh.domain.Category;
import pl.edu.agh.domain.Product;
import pl.edu.agh.domain.Supplier;

import java.util.List;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public interface IDataGeneratorService {

    public List<Category> generateCategories();

    public List<Supplier> generateSuppliers();

    public List<Product> generateProducts(List<Category> categories, List<Supplier> supplier);

}
