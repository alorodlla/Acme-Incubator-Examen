
package acme.features.investor.fundings;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.fundings.Funding;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorFundingRepository extends AbstractRepository {

	@Query("select f from Funding f where f.id=?1")
	Funding findByFundingId(int id);

	@Query("select f from Funding f")
	Collection<Funding> findManyFundings();
}
