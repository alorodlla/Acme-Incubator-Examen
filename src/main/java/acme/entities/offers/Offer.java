
package acme.entities.offers;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.entities.applications.Application;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offer extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				offer;

	@Pattern(regexp = "^(?=(?:.*\\d){1,})(?=(?:.*[a-zA-Z]){1,})(?=(?:.*\\p{Punct}){1,}).{10,}$|^$")
	private String				password;

	@URL
	private String				link;

	@NotNull
	@Valid
	@OneToOne(optional = true)
	private Application			application;
}
