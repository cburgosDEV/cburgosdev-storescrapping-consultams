package cburgosdev.java.Services.Implements;

import cburgosdev.java.Models.Brand;
import cburgosdev.java.Repositories.IBrandRepository;
import cburgosdev.java.Services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandRepository brandRepository;
    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll(Sort.by("name"));
    }
}
