package pl.edu.agh.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.agh.domain.Category;
import pl.edu.agh.domain.Supplier;
import pl.edu.agh.services.interfaces.IDataGeneratorService;
import pl.edu.agh.tutorial.queries.criteriaapi.repositories.SimpleCriteriaApi;

import java.util.List;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class TutorialTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-tutorial.xml");
        IDataGeneratorService dataGeneratorService = ((IDataGeneratorService)context.getBean("dataGeneratorService"));
        List<Category> categories = dataGeneratorService.generateCategories();
        List<Supplier> suppliers = dataGeneratorService.generateSuppliers();
        dataGeneratorService.generateProducts(categories, suppliers);

        SimpleCriteriaApi simpleCriteriaApi = (SimpleCriteriaApi)context.getBean("simpleCriteriaApi");
        System.out.println(simpleCriteriaApi.getAllProducts());

    }

}
