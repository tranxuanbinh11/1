package tranxuanbinh.net.service;

import java.util.Collection;

import tranxuanbinh.net.model.CartItem;

public interface ShoppingCartService {
	
	void add(CartItem newItem);
	void remove(int id);
	CartItem update(int productId , int quantity);
	void clear();
	double getAmount();
	int getCount();
	Collection<CartItem> getAllItems();

}
