package pl.edu.agh.tutorial.performanceTest;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.data.CategoryData;
import pl.edu.agh.repository.BaseHibernateRepository;
import pl.edu.agh.tutorial.domain.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysiu on 2014-06-03.
 */
public class InsertPerformanceTest extends BaseHibernateRepository {

    private static List<Category> categoriesToInsert = new ArrayList<Category>();
    private static int MAX_TEST_SIZE = 10000;

    private static int FLUSH_SIZE = 2000;
    private static int FOURTH_TEST = 100000;

    static {
        for(int i = 0; i < MAX_TEST_SIZE; i++) {
            categoriesToInsert.add(new Category(CategoryData.CATEGORY_NAMES[i % CategoryData.CATEGORY_NAMES.length], CategoryData.CATEGORY_DESCRIPTION[i % CategoryData.CATEGORY_DESCRIPTION.length]));
        }
    }

    public InsertPerformanceTest(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional
    public void testFourthWithoutSessionFlush() {
        for(int i = 0; i < FOURTH_TEST; i++) {
            getSession().save(categoriesToInsert.get(i));
        }
    }

    @Transactional
    public void testFourthWithSessionFlush() {
        for(int i = 0; i < FOURTH_TEST; i++) {
            getSession().save(categoriesToInsert.get(i));
            if(i % FLUSH_SIZE == 0) {
                getSession().flush();
            }
        }
    }

    @Transactional
    public void testMaxWithoutSessionFlush() {
        for(int i = 0; i < MAX_TEST_SIZE; i++) {
            getSession().save(categoriesToInsert.get(i));
        }
    }

    @Transactional
    public void testMaxWithSessionFlush() {
        for(int i = 0; i < MAX_TEST_SIZE; i++) {
            getSession().save(categoriesToInsert.get(i));
            if(i % FLUSH_SIZE == 0) {
                getSession().flush();
            }
        }
    }

    @Transactional
    public void performFlushSizesTest() {
        testMaxWithSessionFlush100();
        testMaxWithSessionFlush200();
        testMaxWithSessionFlush1000();
        testMaxWithSessionFlush5000();
        testMaxWithSessionFlush10000();
    }

    @Transactional
    public void testMaxWithSessionFlush100() {
        for(int i = 0; i < MAX_TEST_SIZE; i++) {
            getSession().save(categoriesToInsert.get(i));
            if(i % 100 == 0) {
                getSession().flush();
            }
        }
    }

    @Transactional
    public void testMaxWithSessionFlush200() {
        for(int i = 0; i < MAX_TEST_SIZE; i++) {
            getSession().save(categoriesToInsert.get(i));
            if(i % 200 == 0) {
                getSession().flush();
            }
        }
    }

    @Transactional
    public void testMaxWithSessionFlush1000() {
        for(int i = 0; i < MAX_TEST_SIZE; i++) {
            getSession().save(categoriesToInsert.get(i));
            if(i % 1000 == 0) {
                getSession().flush();
            }
        }
    }

    @Transactional
    public void testMaxWithSessionFlush5000() {
        for(int i = 0; i < MAX_TEST_SIZE; i++) {
            getSession().save(categoriesToInsert.get(i));
            if(i % 5000 == 0) {
                getSession().flush();
            }
        }
    }

    @Transactional
    public void testMaxWithSessionFlush10000() {
        for(int i = 0; i < MAX_TEST_SIZE; i++) {
            getSession().save(categoriesToInsert.get(i));
            if(i % 10000 == 0) {
                getSession().flush();
            }
        }
    }
}
