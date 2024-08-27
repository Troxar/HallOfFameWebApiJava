package HallOfFame.WebApi.repository;

import HallOfFame.WebApi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}