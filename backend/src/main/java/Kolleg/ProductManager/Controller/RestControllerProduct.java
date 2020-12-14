package Kolleg.ProductManager.Controller;

import Kolleg.ProductManager.Model.Product;
import Kolleg.ProductManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestControllerProduct {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(service.listAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable int id){
        return ResponseEntity.ok().body(service.get(id));
    }

    @PostMapping("/products")
    public  ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(service.save(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(service.update(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable("id") int id){
        service.delete(id);
        return HttpStatus.OK;
    }
}
