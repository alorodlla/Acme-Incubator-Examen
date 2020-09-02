
package acme.features.investor.fundings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.fundings.Funding;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorFundingShowService implements AbstractShowService<Investor, Funding> {

	@Autowired
	private InvestorFundingRepository repository;


	@Override
	public boolean authorise(final Request<Funding> request) {
		assert request != null;
		boolean result;

		result = request.getPrincipal().hasRole(Investor.class);
		return result;
	}

	@Override
	public void unbind(final Request<Funding> request, final Funding entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "description");

	}

	@Override
	public Funding findOne(final Request<Funding> request) {
		assert request != null;

		Funding result;
		int id = request.getModel().getInteger("id");

		result = this.repository.findByFundingId(id);

		return result;
	}

}
