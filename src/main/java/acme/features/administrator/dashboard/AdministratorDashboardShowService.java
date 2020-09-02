
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;
import forms.Dashboard;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "investmentRoundsWithFunding", "applicationWithOffer", "applicationsAccepted");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {

		Dashboard result = new Dashboard();

		Double ratioInvestmentRoundsWithFunding, ratioOfApplicationWithOffer, ratioOfApplicationsAccepted, numberInvestmentRoundFunding, numberApplicationsWithOffer, numberApplicationsAccepted, investmentRounds, applications;

		numberInvestmentRoundFunding = this.repository.findInvestmentRoundWithFunding();
		numberApplicationsWithOffer = this.repository.findNumberApplicationWithOffer();
		numberApplicationsAccepted = this.repository.findNumberApplicatiosAccepted();
		investmentRounds = this.repository.findNumberInvestmentRounds();
		applications = this.repository.findNumberApplications();

		ratioInvestmentRoundsWithFunding = numberInvestmentRoundFunding / investmentRounds;
		ratioOfApplicationWithOffer = numberApplicationsWithOffer / applications;
		ratioOfApplicationsAccepted = numberApplicationsAccepted / applications;

		if (numberInvestmentRoundFunding == 0) {
			ratioInvestmentRoundsWithFunding = 0.;
		} else if (numberApplicationsWithOffer == 0) {
			ratioOfApplicationWithOffer = 0.;
		} else if (numberApplicationsAccepted == 0) {
			ratioOfApplicationsAccepted = 0.;
		}

		result.setInvestmentRoundsWithFunding(ratioInvestmentRoundsWithFunding);
		result.setApplicationWithOffer(ratioOfApplicationWithOffer);
		result.setApplicationsAccepted(ratioOfApplicationsAccepted);
		return result;
	}

}
