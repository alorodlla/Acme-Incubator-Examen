
package acme.features.investor.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.offers.Offer;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorOfferShowService implements AbstractShowService<Investor, Offer> {

	@Autowired
	InvestorOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;

		boolean result;
		int applicationId;
		Application application;
		Investor investor;
		Principal principal;

		applicationId = request.getModel().getInteger("applicationId");
		application = this.repository.findApplicationById(applicationId);
		investor = application.getInvestor();
		principal = request.getPrincipal();
		result = investor.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "offer", "password", "link");

	}

	@Override
	public Offer findOne(final Request<Offer> request) {
		assert request != null;

		Offer result;
		int applicationId;

		applicationId = request.getModel().getInteger("applicationId");
		result = this.repository.findOfferByApplicationId(applicationId);
		return result;
	}
}
