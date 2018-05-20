package at.wagner.smarthome.presenceradar.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Token {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String uid;

	@NotNull
	private boolean active = true;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	private String foundAction;

	private String lostAction;

	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch =
	// FetchType.LAZY)
	// @JoinColumn(name = "foundAction_id")
	// private Set<Action> foundActions = new HashSet<>();

	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch =
	// FetchType.LAZY)
	// @JoinColumn(name = "lostAction_id")
	// private Set<Action> lostActions = new HashSet<>();
}
