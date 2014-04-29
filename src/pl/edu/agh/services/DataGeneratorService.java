package pl.edu.agh.services;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.domain.Address;
import pl.edu.agh.domain.Category;
import pl.edu.agh.domain.Product;
import pl.edu.agh.domain.Supplier;
import pl.edu.agh.generator.CategoryData;
import pl.edu.agh.generator.ProductsData;
import pl.edu.agh.generator.SuppliersData;
import pl.edu.agh.repository.interfaces.IDataGeneratorRepository;
import pl.edu.agh.services.interfaces.IDataGeneratorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class DataGeneratorService implements IDataGeneratorService {

    private IDataGeneratorRepository dataGeneratorRepository;

    public DataGeneratorService(IDataGeneratorRepository dataGeneratorRepository) {
        this.dataGeneratorRepository = dataGeneratorRepository;
    }

    @Override
    @Transactional
    public List<Category> generateCategories() {
        List<Category> categories = new ArrayList<Category>();
        for(int index = 0; index < CategoryData.GENERATED_VALUES; index++) {
            Category category = new Category();
            category.setCategoryName(CategoryData.CATEGORY_NAMES[index]);
            category.setDescription(CategoryData.CATEGORY_DESCRIPTION[index]);
            categories.add(category);
            dataGeneratorRepository.saveCategory(category);
        }
        return categories;
    }

    @Override
    @Transactional
    public List<Supplier> generateSuppliers() {
        List<Supplier> suppliers = new ArrayList<Supplier>();
        for(int index = 0; index < SuppliersData.GENERATED_VALUES; index++) {
            Supplier supplier = new Supplier();
            supplier.setCompanyName(SuppliersData.SUPPLIERS_COMPANY_NAMES[index]);
            supplier.setContactName(SuppliersData.SUPPLIERS_CONTACT_NAMES[index]);
            supplier.setContactTitle(SuppliersData.SUPPLIERS_CONTACT_TITLES[index]);
            supplier.setPhone(SuppliersData.SUPPLIERS_PHONES[index]);
            supplier.setFax(SuppliersData.SUPPLIER_FAX[index]);
            supplier.setHomepage(SuppliersData.SUPPLIER_HOME_PAGES[index]);
            Address address = new Address();
            address.setAddress(SuppliersData.SUPPLIERS_ADDRESSES[index]);
            address.setCity(SuppliersData.SUPPLIERS_CITIES[index]);
            address.setCountry(SuppliersData.SUPPLIERS_COUNTRIES[index]);
            address.setRegion(SuppliersData.SUPPLIERS_REGIONS[index]);
            address.setPostalCode(SuppliersData.SUPPLIERS_POSTAL_CODES[index]);
            supplier.setAddress(address);
            suppliers.add(supplier);
            dataGeneratorRepository.saveSupplier(supplier);
        }
        return suppliers;
    }

    @Override
    @Transactional
    public List<Product> generateProducts(List<Category> categories, List<Supplier> supplier) {
        List<Product> products = new ArrayList<Product>();
        Random random = new Random();
        for(int index = 0; index < ProductsData.GENERATED_VALUES; index++) {
            Product product = new Product();
            product.setProductName(ProductsData.PRODUCT_NAMES[index]);
            product.setQuantityPerUnit(ProductsData.PRODUCT_QUANTITY_PER_UNIT[index]);
            product.setUnitPrice(ProductsData.PRODUCT_UNIT_PRICE[index]);
            product.setUnitsInStock(ProductsData.PRODUCT_UNITS_IN_STOCK[index]);
            product.setUnitsOnOrder(ProductsData.PRODUCT_UNITS_ON_ORDER[index]);
            product.setReorderLevel(ProductsData.PRODUCT_REORDER_LEVEL[index]);
            product.setDiscontinued(ProductsData.PRODUCT_DISCONTINUED[index]);
            product.setCategory(categories.get(random.nextInt(CategoryData.GENERATED_VALUES)));
            product.setSupplier(supplier.get(random.nextInt(SuppliersData.GENERATED_VALUES)));
            dataGeneratorRepository.saveProduct(product);
        }
        return products;
    }
}
