package HallOfFame.WebApi.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String displayName;

    public Person() {}

    public Person(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return this.id.equals(person.id)
                && this.name.equals(person.name)
                && this.displayName.equals(person.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.displayName);
    }

    @Override
    public String toString() {
        return "Person{id=" + this.id + ", name='" + this.name + "', displayName='" + this.displayName + "'}";
    }

}
