
package acme.features.entrepreneur.offer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.offers.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurOfferRepository extends AbstractRepository {

	@Query("select o from Offer o where o.application.id= ?1")
	Offer findOfferByApplicationId(int applicationId);

	@Query("select a from Application a where a.id= ?1")
	Application findApplicationById(int applicationId);

}
