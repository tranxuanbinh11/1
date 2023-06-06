package tranxuanbinh.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tranxuanbinh.net.model.Product;
import tranxuanbinh.net.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	// get product information
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// save product information
	@Override
	public void saveProduct(Product product) {
		this.productRepository.save(product);

	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> optional = productRepository.findById(id);
		Product product = null;

		if (optional.isPresent())
			product = optional.get();
		else {
			throw new RuntimeException("Product not found for id : " + id);
		}
		return product;
	}

	@Override
	public void deleteProductById(int id) {
		this.productRepository.deleteById(id);
	}
	

}
