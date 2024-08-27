package HallOfFame.WebApi.controller;

import HallOfFame.WebApi.model.Person;
import HallOfFame.WebApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        person.setName(personDetails.getName());
        person.setDisplayName(personDetails.getDisplayName());
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "Person deleted successfully!";
    }
}