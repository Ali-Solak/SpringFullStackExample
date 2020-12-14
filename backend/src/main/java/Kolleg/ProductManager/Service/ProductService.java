package Kolleg.ProductManager.Service;

import Kolleg.ProductManager.Model.Product;
import Kolleg.ProductManager.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> listAll(){
        return repo.findAll();
    }

    public Product save(Product product){
        return repo.save(product);
    }

    public Product get(int id){
        return repo.findById(id).get();
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public Product update(Product product){
        Optional<Product> productDb = repo.findById(product.getId());

        if(productDb.isPresent()){
            Product updateProduct = productDb.get();
            updateProduct.setId(product.getId());
            updateProduct.setName(product.getName());
            updateProduct.setBrand(product.getBrand());
            updateProduct.setMadein(product.getMadein());
            updateProduct.setPrice(product.getPrice());
            return updateProduct;
        }
        else {
            System.out.println("doesnt exist");
            return product;
        }
    }

}
