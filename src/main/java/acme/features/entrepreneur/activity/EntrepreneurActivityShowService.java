
package acme.features.entrepreneur.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activities.Activity;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurActivityShowService implements AbstractShowService<Entrepreneur, Activity> {

	@Autowired
	EntrepreneurActivityRepository repository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		boolean result = false;
		boolean aux = false;
		boolean aux2 = false;
		boolean aux3 = false;
		int investmentRoundId;
		InvestmentRound investmentRound;
		Principal principal;

		principal = request.getPrincipal();
		investmentRoundId = request.getModel().getInteger("investmentRoundId");
		investmentRound = this.repository.findOneInvestmentRoundById(investmentRoundId);
		aux2 = !investmentRound.isFinalMode();
		aux3 = investmentRound.getEntrepreneur().getUserAccount().getId() == principal.getAccountId();

		if (request.getPrincipal().hasRole(Entrepreneur.class)) {
			aux = true;
		}

		result = aux && aux2 && aux3;

		return result;
	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "start", "end", "budget");
	}

	@Override
	public Activity findOne(final Request<Activity> request) {
		assert request != null;

		Activity result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
