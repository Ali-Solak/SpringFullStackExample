package Kolleg.ProductManager.Service;

import Kolleg.ProductManager.Model.Producer;
import Kolleg.ProductManager.Model.Product;
import Kolleg.ProductManager.Repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerService {

    @Autowired
    ProducerRepository repo;

    public List<Producer> listAll(){
        return repo.findAll();
    }

    public Producer save(Producer producer){
        return repo.save(producer);
    }

    public Producer get(int producer_id){
        return repo.findById(producer_id).get();
    }

    public void delete(int produser_id){
        repo.deleteById(produser_id);
    }

    public Producer update(Producer producer){

        Optional<Producer> productDb = repo.findById(producer.getId());

        if(productDb.isPresent()){
            Producer updateProduct = productDb.get();
            updateProduct.setId(producer.getId());
            updateProduct.setName(producer.getName());
            return updateProduct;
        }
        else {
            System.out.println("doesnt exist");
            return producer;
        }
    }
}
