package pl.tmk.hibernate.model;

import javax.persistence.*;

@Table
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String city;

    @Column
    private Integer zip;

    @Column
    private String street;

    @Column
    private String houseNumber;

    @Column
    private String apartmentNumber;

    public Address() {
    }

    public Address(String city, Integer zip, String street, String houseNumber, String apartmentNumber) {
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                '}';
    }
}
