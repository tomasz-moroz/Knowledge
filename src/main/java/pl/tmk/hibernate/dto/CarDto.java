package pl.tmk.hibernate.dto;

import pl.tmk.hibernate.enums.Brand;
import pl.tmk.hibernate.model.Car;
import pl.tmk.hibernate.model.Person;
import java.util.List;
import java.util.function.Function;

public class CarDto {

    private Brand brand;

    private String model;

    private List<Person> owners;

    public static Function<CarDto, Car> DtoToCar = new Function<CarDto, Car>() {
        @Override
        public Car apply(CarDto carDto) {
            return new Car(carDto.getBrand(), carDto.getModel());
        }
    };
    public static Function<Car, CarDto> CarToDto = new Function<Car, CarDto>() {
        @Override
        public CarDto apply(Car car) {
            return new CarDto(car.getBrand(), car.getModel());
        }
    };

    public CarDto(Brand brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public CarDto() {
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
        return "CarDto{" +
                "brand=" + brand +
                ", model='" + model + '\'' +
                ", owners=" + owners +
                '}';
    }
}
