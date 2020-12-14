package Kolleg.ProductManager.Repository;

import Kolleg.ProductManager.Model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {
}
