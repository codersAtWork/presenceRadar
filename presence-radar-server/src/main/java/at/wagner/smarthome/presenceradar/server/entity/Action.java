package at.wagner.smarthome.presenceradar.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public abstract class Action {

	@Id
	@GeneratedValue
	private Long id;

	String description;

}
