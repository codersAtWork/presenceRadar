package at.wagner.smarthome.presenceradar.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;

}
