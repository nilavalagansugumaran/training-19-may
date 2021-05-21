package demo.restclients;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("MyRestClient")
public class MyRestClientImpl implements MyRestClient {

	private String baseAddress = "http://localhost:8081/itemManager";
	
	@Override
	public void doRestCalls() {
	
		// Create a Spring RestTemplate object.
		RestTemplate template = new RestTemplate();
		
		// GET an item.
		CatalogItem item2 = template.getForObject(baseAddress + "/item/2", CatalogItem.class);
		System.out.println("CatalogItem 2:\t" + item2);
	
		// GET ALL ITEMS and display them.
		System.out.println("All CatalogItems:");
	
		ParameterizedTypeReference<List<CatalogItem>> responseType = new ParameterizedTypeReference<List<CatalogItem>>() {};
		ResponseEntity<List<CatalogItem>> response = template.exchange(baseAddress + "/items", HttpMethod.GET, null, responseType);
		 
		for (CatalogItem item : response.getBody()) {
			System.out.println("\tCatalogItem as obj:\t" + item);
		}
		
		// DELETE an item.
		template.delete(baseAddress + "/item/2");
		System.out.println("Deleted item 2");
	}
}
