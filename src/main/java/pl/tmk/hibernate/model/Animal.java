package pl.tmk.hibernate.model;

import pl.tmk.hibernate.enums.Species;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Animal {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private Species species;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    private List<Person> owners;

    public Animal() {
    }

    public Animal(String name, Species species) {
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

    public List<Person> getOwners() {
        return owners;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species=" + species +
                ", owners=" + owners +
                '}';
    }
}
