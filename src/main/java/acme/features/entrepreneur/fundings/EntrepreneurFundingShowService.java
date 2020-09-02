
package acme.features.entrepreneur.fundings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.fundings.Funding;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurFundingShowService implements AbstractShowService<Entrepreneur, Funding> {

	@Autowired
	private EntrepreneurFundingRepository repository;


	@Override
	public boolean authorise(final Request<Funding> request) {
		assert request != null;
		boolean result = false;

		int invstmentRoundId;
		InvestmentRound investmentRound;
		Entrepreneur entrepreneur;
		Principal principal;

		invstmentRoundId = request.getModel().getInteger("investmentRoundId");
		investmentRound = this.repository.findInvestmentRoundById(invstmentRoundId);
		entrepreneur = investmentRound.getEntrepreneur();
		principal = request.getPrincipal();

		result = entrepreneur.getUserAccount().getId() == principal.getAccountId();

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
		int id = request.getModel().getInteger("investmentRoundId");

		result = this.repository.findByInvestmentRound(id);

		return result;
	}

}
