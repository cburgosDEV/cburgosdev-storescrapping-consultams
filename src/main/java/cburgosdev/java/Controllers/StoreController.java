package cburgosdev.java.Controllers;

import cburgosdev.java.Models.Store;
import cburgosdev.java.Services.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StoreController {
    @Autowired
    private IStoreService storeService;

    @GetMapping("/api/stores")
    public List<Store> getProductByIdWithDetail() {
        return storeService.findAll();
    }
}