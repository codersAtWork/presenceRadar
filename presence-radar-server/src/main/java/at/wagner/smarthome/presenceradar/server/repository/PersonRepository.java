package at.wagner.smarthome.presenceradar.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import at.wagner.smarthome.presenceradar.server.entity.Person;

//@RepositoryRestResource
//@CrossOrigin(origins = "*")
public interface PersonRepository extends JpaRepository<Person, Long> {

}
