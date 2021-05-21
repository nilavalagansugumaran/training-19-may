package solution.onlineretailer;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogRestController {

	@Autowired
	private Map<Integer, Item> catalog;
	
    @RequestMapping(method=RequestMethod.GET,  
                    headers="Accept=application/json, application/xml, text/plain")
    public Collection<Item> getAllItemsInCatalog() {
    	return catalog.values();
    }

    @RequestMapping(method=RequestMethod.POST, 
                    headers={"Content-Type=application/json, application/xml", "Accept=application/json, application/xml" })
    @ResponseStatus(HttpStatus.CREATED)
    public Item addItemToCatalog(@RequestBody Item item) {
    	System.out.println("Adding " + item);
    	catalog.put(item.getId(), item);
    	return item;
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}", 
                    headers={"Content-Type=application/json, application/xml", "Accept=*/*" })
	public void modifyItemInCatalog(@PathVariable int id, @RequestBody Item item) {
    	if (catalog.containsKey(id)) {
        	System.out.println("Updating item id " + id);
    		catalog.put(id, item);
    	}
	}

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteItemInCatalog(@PathVariable int id) {
		if (catalog.containsKey(id)) {
        	System.out.println("Deleting item id " + id);
			catalog.remove(id);
		}
	}
}