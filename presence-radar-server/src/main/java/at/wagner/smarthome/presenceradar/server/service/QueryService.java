package at.wagner.smarthome.presenceradar.server.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import at.wagner.smarthome.presenceradar.server.entity.Person;
import at.wagner.smarthome.presenceradar.server.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class QueryService implements GraphQLQueryResolver {

	private final PersonRepository personRepository;

	public Collection<Person> allPersons() {
		return personRepository.findAll();
	}

	public Optional<Person> person(Long id) {
		return personRepository.findById(id);
	}
}
