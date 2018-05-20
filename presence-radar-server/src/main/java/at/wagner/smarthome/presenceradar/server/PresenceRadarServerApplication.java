package at.wagner.smarthome.presenceradar.server;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import at.wagner.smarthome.presenceradar.server.entity.Person;
import at.wagner.smarthome.presenceradar.server.entity.Token;
import at.wagner.smarthome.presenceradar.server.repository.PersonRepository;
import at.wagner.smarthome.presenceradar.server.repository.TokenRepository;

@SpringBootApplication
public class PresenceRadarServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PresenceRadarServerApplication.class, args);
	}

	@Bean
	ApplicationRunner init(PersonRepository personRepository, TokenRepository tokenRepository) {
		return args -> {

			Person person = new Person();
			person.setName("Stefan");
			person = personRepository.save(person);

			Token token = new Token();
			token.setName("Stefans GTag Token");
			token.setUid("7C:2F:80:97:0F:3F");
			token.setPerson(person);
			token.setFoundAction("http://192.168.26.10:8080/lockAction?nukiId=185328513&token=jrvpqL&action=1");
			token.setLostAction("http://192.168.26.10:8080/lockAction?nukiId=185328513&token=jrvpqL&action=2");
			// RestAction action = new RestAction();
			// action.setDescription("Action description");
			// action.setUrl("ur");
			// token.getFoundActions().add(action);
			tokenRepository.save(token);

			person = new Person();
			person.setName("Anna Maria");
			person = personRepository.save(person);

			token = new Token();
			token.setName("Anna Marias Handy Token");
			token.setUid("7C:2F:80:97:0F:3F");
			token.setPerson(person);
			token.setFoundAction("http://192.168.26.10:8080/lockAction?nukiId=185328513&token=jrvpqL&action=1");
			token.setLostAction("http://192.168.26.10:8080/lockAction?nukiId=185328513&token=jrvpqL&action=2");
			tokenRepository.save(token);
		};
	}
}
