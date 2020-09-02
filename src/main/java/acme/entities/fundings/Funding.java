
package acme.entities.fundings;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Funding extends DomainEntity {

	private static final long		serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------------
	@NotBlank
	@Size(max = 256)
	private String					description;

	//Relaciones ------------------------------------------------

	@NotNull
	@Valid
	@ManyToMany
	private Collection<Investor>	investor;

	@NotNull
	@Valid
	@OneToOne(optional = true)
	private InvestmentRound			investmentRound;

}
