package cburgosdev.java.Services;

import cburgosdev.java.DTOs.ProductDTO;
import cburgosdev.java.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.HashMap;
import java.util.List;

public interface IProductService {
    Page<ProductDTO> findAllWithDetail(int pageNumber, int pageSize, String brand, Long category, String product, String store);
    ProductDTO findByIdWithDetail(Long productId);
    HashMap<Long, List<ProductDTO>> findBestDiscounts();
}
