package at.wagner.smarthome.presenceradar.server.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import at.wagner.smarthome.presenceradar.server.entity.Person;
import at.wagner.smarthome.presenceradar.server.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PersonController {

	private final PersonRepository repository;

	@GetMapping(path = "/persons")
	public Collection<Person> persons() {
		return repository.findAll();
	}

	@PutMapping(path = "/persons")
	public void update(@RequestBody Person person) {
		repository.save(person);
	}

	@PostMapping(path = "/persons")
	public void create(@RequestBody Person person) {
		repository.save(person);
	}

	@DeleteMapping(path = { "persons/{id}" })
	public void delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}

}
