package pl.tmk.hibernate.model;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="address_id", referencedColumnName = "id",unique = true)
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @Column
    private List<Animal> animal;
}
