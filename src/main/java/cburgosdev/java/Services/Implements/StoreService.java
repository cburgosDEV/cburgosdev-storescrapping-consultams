package cburgosdev.java.Services.Implements;

import cburgosdev.java.Models.Store;
import cburgosdev.java.Repositories.IStoreRepository;
import cburgosdev.java.Services.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService implements IStoreService {
    @Autowired
    IStoreRepository storeRepository;
    @Override
    public List<Store> findAll() {
        return storeRepository.findAll(Sort.by("name"));
    }
}
