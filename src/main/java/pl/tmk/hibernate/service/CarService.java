package pl.tmk.hibernate.service;

import pl.tmk.hibernate.dao.CarDao;
import pl.tmk.hibernate.dto.CarDto;
import pl.tmk.hibernate.enums.Brand;
import pl.tmk.hibernate.model.Car;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class CarService {

    @Inject
    private CarDao carDao;

    public List<Car> findByBrand(Brand brand) {
        return carDao.findByBrand(brand);
    }

    public List<Car> findByModel(String model) {
        return carDao.findByModel(model);
    }

    public CarDto saveCar(CarDto carDto) {
        return carDao.saveCar(carDto);
    }
}
