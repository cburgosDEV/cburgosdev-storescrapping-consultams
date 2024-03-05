package cburgosdev.java.Services.Implements;

import cburgosdev.java.DTOs.ProductDTO;
import cburgosdev.java.Mappers.ProductMapper;
import cburgosdev.java.Models.Product;
import cburgosdev.java.Repositories.IProductRepository;
import cburgosdev.java.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<ProductDTO> findAllWithDetail(int pageNumber, int pageSize, String brand, int category, String product) {
        List<Integer> brandList = null;
        if(!brand.isEmpty()) brandList = Arrays.stream(brand.split(",")).map(Integer::parseInt).toList();
        if(!product.isEmpty()) product = "%" + product.toUpperCase() + "%";
        else product = null;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "discountRate"));
        Page<Product> productsPage = productRepository.getProductByFilters(pageable, brandList, category, product);

        return productsPage.map(ProductMapper::modelToDTO);
    }
    @Override
    public ProductDTO findByIdWithDetail(int productId) {
        Optional<Product> product = productRepository.findById((long) productId);

        return ProductMapper.modelToDTO(product.orElseGet(Product::new));
    }
}
