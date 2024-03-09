package cburgosdev.java.Repositories;

import cburgosdev.java.Models.ProductRecord;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRecordRepository extends JpaRepository<ProductRecord, Long> {
    List<ProductRecord> getProductRecordListByProductId(Sort sort, Long productId);
}
