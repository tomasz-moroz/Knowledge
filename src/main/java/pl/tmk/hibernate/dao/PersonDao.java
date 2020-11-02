package pl.tmk.hibernate.dao;

import pl.tmk.hibernate.dto.PersonDto;
import pl.tmk.hibernate.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonDto save(PersonDto personDto) {
        Person person = PersonDto.DtoToPerson.apply(personDto);
        entityManager.persist(person);
        return PersonDto.personToDto.apply(person);
    }

    public PersonDto findById(Integer id) {
        Person person = entityManager.find(Person.class, id);
        return PersonDto.personToDto.apply(person);
    }

    public Person edit(Integer id, Person person) {
        Person toEdit = entityManager.find(Person.class, id);
        if(toEdit !=null){
            toEdit.setName(person.getName());
            toEdit.setLastName(person.getLastName());
            toEdit.setAddress(person.getAddress());
            toEdit.setBirthDay(person.getBirthDay());
            toEdit.setCar(person.getCar());
            toEdit.setAnimal(person.getAnimal());
            entityManager.merge(toEdit);
            return toEdit;
        }
        return null;
    }

    public boolean remove(Integer id) {
        Person toRemove = entityManager.find(Person.class, id);
        if (toRemove != null){
            entityManager.remove(toRemove);
        return true;
        }
        return false;
    }
}
