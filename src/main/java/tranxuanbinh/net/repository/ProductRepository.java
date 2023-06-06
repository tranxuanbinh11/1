package tranxuanbinh.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tranxuanbinh.net.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
