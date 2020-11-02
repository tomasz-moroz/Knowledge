package pl.tmk.hibernate.model;

import pl.tmk.hibernate.enums.Brand;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Brand brand;

    @Column
    private String model;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    List<Person>owners;

    public Car() {
    }

    public Car(Brand brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Person> getOwners() {
        return owners;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", model='" + model + '\'' +
                ", owners=" + owners +
                '}';
    }
}
