package cburgosdev.java.Services.Implements;

import cburgosdev.java.Constants.CategoryConstants;
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
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<ProductDTO> findAllWithDetail(int pageNumber, int pageSize, String brand, Long category, String product) {
        List<Long> brandList = null;
        if(!brand.isEmpty()) brandList = Arrays.stream(brand.split(",")).map(Long::parseLong).toList();
        if(!product.isEmpty()) product = "%" + product.toUpperCase() + "%";
        else product = null;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "discountRate"));
        Page<Product> productsPage = productRepository.getProductByFilters(pageable, brandList, category, product);

        return productsPage.map(ProductMapper::modelToDTO);
    }
    @Override
    public ProductDTO findByIdWithDetail(Long productId) {
        Optional<Product> product = productRepository.findById(productId);

        return ProductMapper.modelToDTO(product.orElseGet(Product::new));
    }

    @Override
    public HashMap<Long, List<ProductDTO>> findBestDiscounts() {
        HashMap<Long, List<ProductDTO>> bestDiscounts = new HashMap<>();

        Pageable pageable = PageRequest.of(0, 6);
        Page<Product> listSmartphones = productRepository.getProductWithBestDiscount(pageable, CategoryConstants.SMARTPHONES);
        Page<Product> listToys = productRepository.getProductWithBestDiscount(pageable, CategoryConstants.TOYS);
        Page<Product> listLaptops = productRepository.getProductWithBestDiscount(pageable, CategoryConstants.LAPTOPS);

        bestDiscounts.put(CategoryConstants.SMARTPHONES, listSmartphones.map(ProductMapper::modelToDTOBestDiscounts).getContent());
        bestDiscounts.put(CategoryConstants.TOYS, listToys.map(ProductMapper::modelToDTOBestDiscounts).getContent());
        bestDiscounts.put(CategoryConstants.LAPTOPS, listLaptops.map(ProductMapper::modelToDTOBestDiscounts).getContent());

        return bestDiscounts;
    }
}
