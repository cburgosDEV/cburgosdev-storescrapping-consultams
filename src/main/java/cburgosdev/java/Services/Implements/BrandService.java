package cburgosdev.java.Services.Implements;

import cburgosdev.java.Models.Brand;
import cburgosdev.java.Repositories.IBrandRepository;
import cburgosdev.java.Services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandRepository brandRepository;
    @Override
    public List<Brand> findAll(String category) {
        List<Long> categoryList = null;
        if(!category.isEmpty()) categoryList = Arrays.stream(category.split(",")).map(Long::parseLong).toList();

        return brandRepository.getBrandsByCategoryId(Sort.by("name"), categoryList);
    }
}
