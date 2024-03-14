package cburgosdev.java.Controllers;

import cburgosdev.java.DTOs.ProductDTO;
import cburgosdev.java.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/api/products")
    public Page<ProductDTO> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String brand,
            @RequestParam(defaultValue = "0") Long category,
            @RequestParam(defaultValue = "") String product,
            @RequestParam(defaultValue = "") String store
    ) {
        return productService.findAllWithDetail(page, size, brand, category, product, store);
    }
    @GetMapping("/api/products/{id}")
    public ProductDTO getProductByIdWithDetail(@PathVariable Long id) {
        return productService.findByIdWithDetail(id);
    }

    @GetMapping("/api/products/bestDiscounts")
    public HashMap<Long, List<ProductDTO>> getProductsWithBestDiscounts() {
        return productService.findBestDiscounts();
    }
}
