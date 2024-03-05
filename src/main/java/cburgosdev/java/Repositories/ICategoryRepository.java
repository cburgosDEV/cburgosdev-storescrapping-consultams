package cburgosdev.java.Repositories;

import cburgosdev.java.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
