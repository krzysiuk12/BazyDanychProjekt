package pl.edu.agh.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.agh.tutorial.generator.DataGeneratorRepository;
import pl.edu.agh.tutorial.queries.criteriaapi.repositories.ProjectionsCriteriaApi;
import pl.edu.agh.tutorial.queries.criteriaapi.repositories.RestrictionsCriteriaApi;
import pl.edu.agh.tutorial.queries.criteriaapi.repositories.SimpleCriteriaApi;

import java.util.List;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class TutorialTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-tutorial.xml");
/*        DataGeneratorRepository dataGeneratorService = ((DataGeneratorRepository)context.getBean("dataGenaratorTutorialRepository"));
        dataGeneratorService.generateData();*/


        SimpleCriteriaApi simpleCriteriaApi = (SimpleCriteriaApi)context.getBean("simpleCriteriaApi");
/*        simpleCriteriaApi.getAllProducts();
        simpleCriteriaApi.getCompaniesTypesOfResult();
        simpleCriteriaApi.getCompaniesWithCriteriaOrdering();*/
/*        simpleCriteriaApi.getOrdersFetchModes();*/
/*        simpleCriteriaApi.getOrdersWithResultTransformers();*/
        simpleCriteriaApi.cartesianProductProblem2Collections();


/*        RestrictionsCriteriaApi restrictionsCriteriaApi = (RestrictionsCriteriaApi)context.getBean("restrictionsCriteriaApi");
        restrictionsCriteriaApi.getCompaniesWithNameRestriction();
        restrictionsCriteriaApi.getCompaniesWithNameRestrictionMatchModes();
        restrictionsCriteriaApi.getIndividualsWithInRestriction();
        restrictionsCriteriaApi.getOrdersWithNullRestrictions();
        restrictionsCriteriaApi.getOrdersWithOrderDetailsCollectionRestrictions();
        restrictionsCriteriaApi.getProductCombinedRestrictions();
        restrictionsCriteriaApi.getProductsWithNumberRestrictions();*/

        ProjectionsCriteriaApi projectionsCriteriaApi = (ProjectionsCriteriaApi)context.getBean("projectionsCriteriaApi");
        projectionsCriteriaApi.rowCountProjection();
        projectionsCriteriaApi.aggregationFunctionsProjections();
        projectionsCriteriaApi.groupByProjections();
    }

}
