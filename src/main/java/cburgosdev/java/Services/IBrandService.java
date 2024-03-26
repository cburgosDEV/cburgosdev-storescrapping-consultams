package cburgosdev.java.Services;

import cburgosdev.java.Models.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> findAll(String category);
}
