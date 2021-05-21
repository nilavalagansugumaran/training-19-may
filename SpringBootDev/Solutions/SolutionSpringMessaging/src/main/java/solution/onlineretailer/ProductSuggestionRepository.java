package solution.onlineretailer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductSuggestionRepository {

	@PersistenceContext
	protected EntityManager entityManager;
    
    @Autowired
    private JmsTemplate jmsTemplate;

    public List<ProductSuggestion> getProductSuggestions() throws DataAccessException {
		String jpql = "select p from ProductSuggestion p";
		TypedQuery<ProductSuggestion> query = entityManager.createQuery(jpql, ProductSuggestion.class);
	    return query.getResultList();
	}
    
	@Transactional
	public void insertProductSuggestion(ProductSuggestion ps) {
		entityManager.persist(ps);
		sendMessageIfValuableProductSuggestion(ps);
	}
	
	@Transactional
	public void modifyPrice(long id, double newPrice) {
		ProductSuggestion ps = entityManager.find(ProductSuggestion.class, id);
		ps.setRecommendedPrice(newPrice);
		sendMessageIfValuableProductSuggestion(ps);
	}
	
	@Transactional
	public void modifySales(long id, long newSales) {
		ProductSuggestion ps = entityManager.find(ProductSuggestion.class, id);
		ps.setEstimatedAnnualSales(newSales);
		sendMessageIfValuableProductSuggestion(ps);
	}
	
	@Transactional
	public void deleteProductSuggestions() {
		Query query = entityManager.createQuery("delete from ProductSuggestion");
		query.executeUpdate();
	}
	
	private void sendMessageIfValuableProductSuggestion(ProductSuggestion ps) {
		if (ps.getRecommendedPrice() * ps.getEstimatedAnnualSales() >= 10_000) {
			jmsTemplate.convertAndSend("valuableProductSuggestionsDestination", ps);			
		}
	}
}
