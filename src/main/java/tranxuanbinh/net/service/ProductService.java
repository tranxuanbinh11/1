package tranxuanbinh.net.service;

import java.util.List;

import tranxuanbinh.net.model.Product;



public interface ProductService {
	List<Product> getAllProducts();
	void saveProduct(Product product);
	Product getProductById(int id);
	void deleteProductById(int id);
	

}