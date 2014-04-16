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
public class TutorialTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-tutorial.xml");
    }

}
