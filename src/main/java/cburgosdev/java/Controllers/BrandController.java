package cburgosdev.java.Controllers;

import cburgosdev.java.Models.Brand;
import cburgosdev.java.Services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    @GetMapping("/api/brands")
    public List<Brand> getProductByIdWithDetail(@RequestParam(defaultValue = "0") Long category) {
        return brandService.findAll(category);
    }
}
