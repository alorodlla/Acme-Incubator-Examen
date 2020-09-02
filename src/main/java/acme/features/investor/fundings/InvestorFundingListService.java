
package acme.features.investor.fundings;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.fundings.Funding;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorFundingListService implements AbstractListService<Investor, Funding> {

	@Autowired
	InvestorFundingRepository repository;


	@Override
	public boolean authorise(final Request<Funding> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Funding> request, final Funding entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "description");

	}

	@Override
	public Collection<Funding> findMany(final Request<Funding> request) {
		assert request != null;

		Collection<Funding> result;

		result = this.repository.findManyFundings();

		return result;
	}
}
