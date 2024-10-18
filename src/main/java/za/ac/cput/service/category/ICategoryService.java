package za.ac.cput.service.category;

import za.ac.cput.domain.Category;
import za.ac.cput.service.IService;

import java.util.List;

public interface ICategoryService extends IService<Category,Long> {

    List<Category> getAll();
}
