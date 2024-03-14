package cburgosdev.java.Controllers;

import cburgosdev.java.Models.Category;
import cburgosdev.java.Services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/api/categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }
}
