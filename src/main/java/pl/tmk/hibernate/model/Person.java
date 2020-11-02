package pl.tmk.hibernate.model;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private LocalDate birthDay;

    @Nullable
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="address_id", referencedColumnName = "id",unique = true)
    private Address address;

    @Nullable
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @Nullable
    @OneToMany()
    private List<Animal> animal;

    public Person(String name, String lastName, LocalDate birthDay, Address address, Car car, List<Animal> animal) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.car = car;
        this.animal = animal;
    }

    public Person(String name, String lastName, LocalDate birthDay) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
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
        return "Person{" +
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
