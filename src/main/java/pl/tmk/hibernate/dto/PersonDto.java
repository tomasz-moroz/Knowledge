package pl.tmk.hibernate.dto;

import pl.tmk.hibernate.model.Address;
import pl.tmk.hibernate.model.Animal;
import pl.tmk.hibernate.model.Car;
import pl.tmk.hibernate.model.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class PersonDto {
    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthDay;
    private Address address;
    private Car car;
    private List<Animal> animal;

    public static Function<PersonDto, Person> DtoToPerson = new Function<PersonDto, Person>() {
        @Override
        public Person apply(PersonDto personDto) {
            return new Person(personDto.getName(), personDto.getLastName(), personDto.getBirthDay(), personDto.getAddress(), personDto.getCar(), personDto.getAnimal());
        }
    };
    public static Function<Person, PersonDto> personToDto = new Function<Person, PersonDto>() {
        @Override
        public PersonDto apply(Person person) {
            return new PersonDto(person.getName(), person.getLastName(), person.getBirthDay(), person.getAddress(), person.getCar(), person.getAnimal());
        }
    };

    public PersonDto() {
    }

    public PersonDto(String name, String lastName, LocalDate birthDay, Address address, Car car, List<Animal> animal) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.car = car;
        this.animal = animal;
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", address=" + address +
                ", car=" + car +
                ", animal=" + animal +
                '}';
    }
}
