package pl.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.knowledge.model.Person;

public class PersonDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String name;
    private String lastName;

    public static Person dtoToPerson(PersonDto personDto){
        Person person = new Person();
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        return person;
    }

    public static PersonDto personToDto(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setLastName(person.getLastName());
        return personDto;
    }
    public PersonDto(Integer id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public PersonDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
