package cburgosdev.java.Services.Implements;

import cburgosdev.java.Models.Category;
import cburgosdev.java.Repositories.ICategoryRepository;
import cburgosdev.java.Services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll(Sort.by("name"));
    }
}
