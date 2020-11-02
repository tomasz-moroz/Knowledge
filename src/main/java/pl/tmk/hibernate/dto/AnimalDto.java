package pl.tmk.hibernate.dto;

import pl.tmk.hibernate.enums.Brand;
import pl.tmk.hibernate.enums.Species;
import pl.tmk.hibernate.model.Animal;
import pl.tmk.hibernate.model.Car;

import java.util.function.Function;

public class AnimalDto {

    private Integer id;

    private String name;

    private Species species;

    public static Function<AnimalDto, Animal> DtoToAnimal = new Function<AnimalDto, Animal>() {
        @Override
        public Animal apply(AnimalDto animalDto) {
            return new Animal(animalDto.getName(), animalDto.getSpecies());
        }
    };
    public static Function<Animal, AnimalDto> AnimalToDto = new Function<Animal, AnimalDto>() {
        @Override
        public AnimalDto apply(Animal animal) {
            return new AnimalDto(animal.getName(), animal.getSpecies());
        }
    };

    public AnimalDto() {
    }

    public AnimalDto(String name, Species species) {
        this.name = name;
        this.species = species;
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

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "AnimalDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species=" + species +
                '}';
    }
}
