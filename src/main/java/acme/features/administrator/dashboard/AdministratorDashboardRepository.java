
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(f) from Funding f")
	Double findInvestmentRoundWithFunding();

	@Query("select count(o) from Offer o")
	Double findNumberApplicationWithOffer();

	@Query("select count(a) from Application a where a.status != 'accepted'")
	Double findNumberApplicatiosAccepted();

	@Query("SELECT count (a) from Application a")
	Double findNumberApplications();

	@Query("SELECT count (i) from InvestmentRound i")
	Double findNumberInvestmentRounds();
}
