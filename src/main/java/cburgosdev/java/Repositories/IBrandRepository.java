package cburgosdev.java.Repositories;

import cburgosdev.java.Models.Brand;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> getBrandsByCategoryId(Sort sort, Long categoryId);
}
