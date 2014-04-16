package pl.edu.agh.services;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.domain.Category;
import pl.edu.agh.repository.interfaces.IDataGeneratorRepository;
import pl.edu.agh.services.interfaces.IDataGeneratorService;

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
    public void generateCategories() {
        Category category = new Category();
        category.setCategoryName("Nowa kategoria");
        category.setDescription("Opis");
        dataGeneratorRepository.saveCategory(category);
    }
}
