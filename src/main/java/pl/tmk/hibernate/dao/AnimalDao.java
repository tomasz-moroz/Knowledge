package pl.tmk.hibernate.dao;

import pl.tmk.hibernate.dto.AnimalDto;
import pl.tmk.hibernate.dto.PersonDto;
import pl.tmk.hibernate.enums.Species;
import pl.tmk.hibernate.model.Animal;
import pl.tmk.hibernate.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AnimalDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Animal> findBySpecies(Species species) {
        Query query = entityManager.createQuery("SELECT species FROM Animal species WHERE species.species=:species");
        query.setParameter("species", species.toString());

        List<Animal> result = query.getResultList();
        return result;
    }
    public List<Animal> findByName (String name) {
        Query query = entityManager.createQuery("SELECT animal FROM Animal animal WHERE animal.name=:name");
        query.setParameter("name", name);

        List<Animal> result = query.getResultList();
        return result;
    }

    public AnimalDto saveAnimal(AnimalDto animalDto) {
        Animal animal = AnimalDto.DtoToAnimal.apply(animalDto);
        entityManager.persist(animal);
        return AnimalDto.AnimalToDto.apply(animal);
    }
}