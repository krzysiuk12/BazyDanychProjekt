package pl.edu.agh.repository.interfaces;

import pl.edu.agh.domain.Category;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public interface IDataGeneratorRepository {

    Long saveCategory(Category category);

}
