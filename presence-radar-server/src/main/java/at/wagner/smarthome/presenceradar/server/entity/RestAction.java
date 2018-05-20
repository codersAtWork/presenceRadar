package at.wagner.smarthome.presenceradar.server.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RestAction extends Action {

	@NotNull
	private String url;

}
