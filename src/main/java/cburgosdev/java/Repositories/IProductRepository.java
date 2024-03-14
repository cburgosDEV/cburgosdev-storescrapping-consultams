package cburgosdev.java.Repositories;

import cburgosdev.java.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE (:brand IS NULL OR p.brand.id IN (:brand)) AND (:category = 0 OR p.category.id = :category) AND (:product IS NULL OR p.name LIKE :product) AND (:store IS NULL OR p.store.id IN (:store))")
    Page<Product> getProductByFilters(Pageable pageable, List<Long> brand, Long category, String product, List<Long> store);
    Product getProductByName(String name);
    List<Product> getProductListByName(String name);
    @Query("SELECT p FROM Product p WHERE (:category = 0 OR p.category.id = :category) ORDER BY p.discountRate desc")
    Page<Product> getProductWithBestDiscount(Pageable pageable, Long category);
}
