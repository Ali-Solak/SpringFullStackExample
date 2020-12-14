package Kolleg.ProductManager.Repository;

import Kolleg.ProductManager.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> findAllByBrand(int id);

    @Query(value = "SELECT * FROM Product p order by p.price desc", nativeQuery = true)
    List<Product> showProductsSortedByPrice();
}
