package pl.edu.agh.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.agh.domain.Category;
import pl.edu.agh.domain.Supplier;
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

        IWarehouseService warehouseService = ((IWarehouseService)context.getBean("warehouseService"));
        System.out.println(warehouseService.getAllCategories());
        System.out.println(warehouseService.getAllSuppliers());
        System.out.println(warehouseService.getAllProducts());
    }

}
