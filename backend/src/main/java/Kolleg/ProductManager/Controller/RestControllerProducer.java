package Kolleg.ProductManager.Controller;

import Kolleg.ProductManager.Model.Producer;
import Kolleg.ProductManager.Service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestControllerProducer {

    @Autowired
    private ProducerService service;

    @GetMapping("/producers")
    public ResponseEntity<List<Producer>> getAllProduct(){
        return ResponseEntity.ok().body(service.listAll());
    }

    @GetMapping("/producers/{id}")
    public ResponseEntity<Producer> getProductByID(@PathVariable int id){
        return ResponseEntity.ok().body(service.get(id));
    }

    @PostMapping("/producers")
    public  ResponseEntity<Producer> createProduct(@RequestBody Producer producer){
        return ResponseEntity.ok().body(service.save(producer));
    }

    @PutMapping("/producers/{id}")
    public ResponseEntity<Producer> updateProduct(@PathVariable int id, @RequestBody Producer producer) {
        producer.setId(id);
        return ResponseEntity.ok().body(service.update(producer));
    }

    @DeleteMapping("/producers/{id}")
    public HttpStatus deleteProduct(@PathVariable("id") int id){
        service.delete(id);
        return HttpStatus.OK;
    }
}
