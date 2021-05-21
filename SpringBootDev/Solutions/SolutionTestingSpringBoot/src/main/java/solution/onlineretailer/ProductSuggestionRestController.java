package solution.onlineretailer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productSuggestions") 
public class ProductSuggestionRestController {

	@Autowired
	private ProductSuggestionRepository repository;
	
    @RequestMapping(method=RequestMethod.GET, 
                    headers="Accept=application/json, application/xml, text/plain")
    public List<ProductSuggestion> getAllProductSuggestions() {
    	return repository.getProductSuggestions();
    }

    @RequestMapping(
    		method=RequestMethod.POST, 
            headers={"Content-Type=application/json, application/xml", "Accept=application/json, application/xml" }
    )
	@ResponseStatus(HttpStatus.CREATED)
	public ProductSuggestion insertProductSuggestion(@RequestBody ProductSuggestion productSuggestion) {
		repository.insertProductSuggestion(productSuggestion);
		return productSuggestion;
	}

    @RequestMapping(method=RequestMethod.PUT, value="/modifyPrice/{id}")
	public void modifyPrice(@PathVariable long id, @RequestParam double newPrice) {
    	repository.modifyPrice(id, newPrice);
	}

    @RequestMapping(method=RequestMethod.PUT, value="/modifySales/{id}")
	public void modifySales(@PathVariable long id, @RequestParam long newSales) {
    	repository.modifySales(id, newSales);
	}

    @RequestMapping(method=RequestMethod.DELETE)
	public void deleteAllProductSuggestions() {
    	repository.deleteProductSuggestions();
	}
}