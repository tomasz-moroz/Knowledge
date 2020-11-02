package pl.tmk.hibernate.dto;

import pl.tmk.hibernate.model.Address;

import java.util.function.Function;

public class AddressDto {

    private Integer id;
    private String city;
    private Integer zip;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    public static Function <AddressDto, Address> DtoToAddress = new Function<AddressDto, Address>() {
        @Override
        public Address apply(AddressDto addressDto) {
            return new Address(addressDto.getCity(),
            addressDto.getZip(),
            addressDto.getStreet(),
            addressDto.getHouseNumber(),
            addressDto.getApartmentNumber());
        }
    };
    public static Function <Address, AddressDto> addressToDto = new Function<Address, AddressDto>() {
        @Override
        public AddressDto apply(Address address) {
            return new AddressDto(address.getCity(),
                    address.getZip(),
                    address.getStreet(),
                    address.getHouseNumber(),
                    address.getApartmentNumber());
        }
    };

    public AddressDto(String city, Integer zip, String street, String houseNumber, String apartmentNumber) {
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public AddressDto() {
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
        return "AddressDto{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
