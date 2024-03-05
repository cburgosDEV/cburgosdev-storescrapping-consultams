package cburgosdev.java.Repositories;

import cburgosdev.java.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE (:brand IS NULL OR p.brand.id IN (:brand)) AND (:category = 0 OR p.category.id = :category) AND (:product IS NULL OR p.name LIKE :product)")
    Page<Product> getProductByFilters(Pageable pageable, List<Integer> brand, int category, String product);
    Product getProductByName(String name);
    List<Product> getProductListByName(String name);
}
