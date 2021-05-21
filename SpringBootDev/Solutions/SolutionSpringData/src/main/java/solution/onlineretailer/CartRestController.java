package solution.onlineretailer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRestController {

	@Autowired
	private Map<Integer, Item> catalog;
	
	@Autowired
	private CartService service;
	
    @RequestMapping(method=RequestMethod.GET, value="/items", 
                    headers="Accept=application/json, application/xml, text/plain")
    public List<Item> getAllItems() {
    	return service.getAllItemsInCart()
    			      .keySet()
    			      .stream()
    			      .map(id -> catalog.get(id))
    			      .collect(Collectors.toList());
    }

    @RequestMapping(method=RequestMethod.GET, value="/quantityForItem/{itemId}", 
                    headers="Accept=application/json, application/xml, text/plain")
	public int getQuantityForItem(@PathVariable int itemId) {
    	Integer quantity = service.getAllItemsInCart().get(itemId);
    	if (quantity != null) {
    		return quantity;
    	}
    	else {
    		return 0;
    	}
	}
    
    @RequestMapping(method=RequestMethod.GET, value="/cartCost", 
	                headers="Accept=application/json, application/xml, text/plain")
	public double getCartCost() {
    	return service.calculateCartCost();
	}
}