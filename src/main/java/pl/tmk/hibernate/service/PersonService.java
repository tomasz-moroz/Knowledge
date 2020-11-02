package pl.tmk.hibernate.service;

import pl.tmk.hibernate.dao.PersonDao;
import pl.tmk.hibernate.dto.PersonDto;
import pl.tmk.hibernate.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PersonService {

    @Inject
    PersonDao personDao;

    public PersonDto savePerson (PersonDto personDto) {
        return personDao.save(personDto);
    }

    public PersonDto findById(Integer id){
        return personDao.findById(id);
    }

    public Person edit (Integer id, Person person) {
        return personDao.edit(id, person);
    }

    public boolean remove (Integer id) {
        return personDao.remove(id);
    }
}
