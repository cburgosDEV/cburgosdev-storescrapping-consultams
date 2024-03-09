package cburgosdev.java.Repositories;

import cburgosdev.java.Models.ProductDetail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    List<ProductDetail> getProductDetailListByProductId(Sort sort, Long productId);
}
