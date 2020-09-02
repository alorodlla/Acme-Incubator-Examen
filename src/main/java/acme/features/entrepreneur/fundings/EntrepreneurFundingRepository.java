
package acme.features.entrepreneur.fundings;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.fundings.Funding;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurFundingRepository extends AbstractRepository {

	@Query("select f from Funding f join f.investmentRound ir where ir.id=?1")
	Funding findByInvestmentRound(int investmentRoundId);

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findInvestmentRoundById(int id);

	@Query("select i from Investor i")
	Collection<Investor> findInvestors();

	@Query("select f from Funding f where f.id=?1")
	Funding findOneFundingById(int fundingId);
}
