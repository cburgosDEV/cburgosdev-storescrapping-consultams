package cburgosdev.java.Services;

import cburgosdev.java.DTOs.ProductDTO;
import cburgosdev.java.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IProductService {
    Page<ProductDTO> findAllWithDetail(int pageNumber, int pageSize, String brand, int category, String product);
    ProductDTO findByIdWithDetail(int productId);
}
