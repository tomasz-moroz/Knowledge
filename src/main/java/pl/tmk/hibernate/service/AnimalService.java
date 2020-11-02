package pl.tmk.hibernate.service;

import pl.tmk.hibernate.dao.AnimalDao;
import pl.tmk.hibernate.dao.PersonDao;
import pl.tmk.hibernate.dto.AnimalDto;
import pl.tmk.hibernate.enums.Species;
import pl.tmk.hibernate.model.Animal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import java.util.List;


@RequestScoped
public class AnimalService {

    @Inject
    private AnimalDao animalDao;

    public List<Animal> findBySpecies (Species species) {
        return animalDao.findBySpecies(species);
    }
    public List<Animal> findByName(String name){
        return animalDao.findByName(name);
    }

    public AnimalDto saveAnimal(AnimalDto animalDto) {
        return animalDao.saveAnimal(animalDto);
    }
}
