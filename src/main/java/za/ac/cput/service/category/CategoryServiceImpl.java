package za.ac.cput.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Category;
import za.ac.cput.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category read(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id ));
    }

    @Override
    public Category update(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            return categoryRepository.save(category);
        } else {
            throw new IllegalArgumentException("Category not found with id: " + category.getId());
        }
    }

    @Override
    public boolean delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        } else {
            throw new IllegalArgumentException("Category not found with id: " + id);
        }
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
