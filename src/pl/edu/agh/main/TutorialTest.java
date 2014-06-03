package pl.edu.agh.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.agh.tutorial.performanceTest.InsertPerformanceTest;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class TutorialTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-tutorial.xml");
/*        DataGeneratorRepository dataGeneratorService = ((DataGeneratorRepository)context.getBean("dataGenaratorTutorialRepository"));
        dataGeneratorService.generateData();*/


/*        SimpleCriteriaApi simpleCriteriaApi = (SimpleCriteriaApi)context.getBean("simpleCriteriaApi");
        simpleCriteriaApi.getAllProducts();
        simpleCriteriaApi.getCompaniesTypesOfResult();
        simpleCriteriaApi.getCompaniesWithCriteriaOrdering();
        simpleCriteriaApi.getOrdersFetchModes();
        simpleCriteriaApi.getOrdersWithResultTransformers();
        simpleCriteriaApi.cartesianProductProblem2Collections();*/


/*        RestrictionsCriteriaApi restrictionsCriteriaApi = (RestrictionsCriteriaApi)context.getBean("restrictionsCriteriaApi");
        restrictionsCriteriaApi.getCompaniesWithNameRestriction();
        restrictionsCriteriaApi.getCompaniesWithNameRestrictionMatchModes();
        restrictionsCriteriaApi.getIndividualsWithInRestriction();
        restrictionsCriteriaApi.getOrdersWithNullRestrictions();
        restrictionsCriteriaApi.getOrdersWithOrderDetailsCollectionRestrictions();
        restrictionsCriteriaApi.getProductCombinedRestrictions();
        restrictionsCriteriaApi.getProductsWithNumberRestrictions();*/

/*        ProjectionsCriteriaApi projectionsCriteriaApi = (ProjectionsCriteriaApi)context.getBean("projectionsCriteriaApi");
        projectionsCriteriaApi.rowCountProjection();
        projectionsCriteriaApi.aggregationFunctionsProjections();
        projectionsCriteriaApi.groupByProjections();*/

/*        SimpleHql simpleHql = (SimpleHql)context.getBean("simpleHql");
        simpleHql.associationsAndJoinsExamples();
        simpleHql.hqlExpressionExamples();
        simpleHql.dateManipulationExamples();
        simpleHql.stringManipulationExamples();
        simpleHql.aggregateFunctions();*/
/*        simpleHql.groupByExample();

        NamedQueriesExamples namedQueriesExamples = (NamedQueriesExamples)context.getBean("namedQueries");
        namedQueriesExamples.findAllProductsNamedQuery();
        namedQueriesExamples.findAllProductsWithUnitStockBetweenNamedQuery();
        namedQueriesExamples.findAllProductsWithCategoryNamedQuery();
        //TODO: namedQueriesExamples.findAllProductsSQLNamedQuery();
        namedQueriesExamples.findAllProductsAnnotationsNamedQuery();
        namedQueriesExamples.findAllProductsWithCategoryAnootationsNamedQuery();
        namedQueriesExamples.findAllProductsWithUnitStockBetweenAnnotationsNamedQuery();*/

        InsertPerformanceTest insertPerformanceTest = (InsertPerformanceTest)context.getBean("insertPerformanceTest");
        //insertPerformanceTest.testMaxWithoutSessionFlush();
        //insertPerformanceTest.testMaxWithSessionFlush();
        insertPerformanceTest.testMaxWithSessionFlush100();
        insertPerformanceTest.testMaxWithSessionFlush200();
        insertPerformanceTest.testMaxWithSessionFlush1000();
        insertPerformanceTest.testMaxWithSessionFlush5000();
        insertPerformanceTest.testMaxWithSessionFlush10000();
    }

}
