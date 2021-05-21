package solution.onlineretailer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CartService {

	@Autowired
	private CartRepository repository;

	@Value("#{catalog}")	
	private Map<Integer, Item> catalog;
	
	public void addItemToCart(int id, int quantity) {
		if (catalog.containsKey(id)) {
			repository.add(id, quantity);
		}
	}
	
	public void removeItemFromCart(int id) {
		repository.remove(id);
	}
	
	public Map<Integer, Integer> getAllItemsInCart() {
		return repository.getAll();
	}
	
	public double calculateCartCost() {
		Map<Integer, Integer> items = repository.getAll();
		
		double totalCost = 0;
		for (Map.Entry<Integer, Integer> item: items.entrySet()) {
			int id = item.getKey();
			int quantity = item.getValue();
			double itemCost = catalog.get(id).getPrice() * quantity;
			totalCost += itemCost;
		}
		return totalCost;
	}
}
