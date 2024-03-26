package cburgosdev.java.Repositories;

import cburgosdev.java.Models.Brand;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBrandRepository extends JpaRepository<Brand, Long> {
    @Query("SELECT b FROM Brand b WHERE (:categoryId IS NULL OR b.categoryId IN (:categoryId))")
    List<Brand> getBrandsByCategoryId(Sort sort, List<Long> categoryId);
}
