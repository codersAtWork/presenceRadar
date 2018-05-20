package at.wagner.smarthome.presenceradar.server.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import at.wagner.smarthome.presenceradar.server.entity.Person;
import at.wagner.smarthome.presenceradar.server.entity.Token;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TokenRepository extends JpaRepository<Token, Long> {

	@Query
	Collection<Token> findByPerson(Person person);

}
