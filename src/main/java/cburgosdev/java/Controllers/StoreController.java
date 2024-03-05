package cburgosdev.java.Controllers;

import cburgosdev.java.DTOs.ProductDTO;
import cburgosdev.java.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StoreController {
    @Autowired
    private IProductService productService;
    @GetMapping("/api/products")
    public Page<ProductDTO> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String brand,
            @RequestParam(defaultValue = "0") int category,
            @RequestParam(defaultValue = "") String product
    ) {
        return productService.findAllWithDetail(page, size, brand, category, product);
    }
    @GetMapping("/api/products/{id}")
    public ProductDTO getProductByIdWithDetail(@PathVariable int id) {
        return productService.findByIdWithDetail(id);
    }
}