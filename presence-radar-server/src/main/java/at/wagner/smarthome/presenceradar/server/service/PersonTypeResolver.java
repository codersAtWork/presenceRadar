package at.wagner.smarthome.presenceradar.server.service;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import at.wagner.smarthome.presenceradar.server.entity.Person;
import at.wagner.smarthome.presenceradar.server.entity.Token;
import at.wagner.smarthome.presenceradar.server.repository.TokenRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonTypeResolver implements GraphQLResolver<Person> {

	private final TokenRepository tokenRepository;

	public Collection<Token> getTokens(Person person) {

		return tokenRepository.findByPerson(person);

	}

}
