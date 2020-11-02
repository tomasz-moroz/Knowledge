package pl.tmk.hibernate.dao;

import pl.tmk.hibernate.dto.CarDto;
import pl.tmk.hibernate.dto.PersonDto;
import pl.tmk.hibernate.enums.Brand;
import pl.tmk.hibernate.model.Car;
import pl.tmk.hibernate.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CarDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Car> findByBrand(Brand brand) {
        Query query = entityManager.createQuery("SELECT brand FROM Car brand WHERE brand.brand=:brand");
        query.setParameter("brand", brand.toString());

        List<Car> result = query.getResultList();
        return result;
    }

    public List<Car> findByModel(String model) {
        Query query = entityManager.createQuery("SELECT car FROM Car car WHERE car.model=:model");
        query.setParameter("model", model);

        List<Car> result = query.getResultList();
        return result;
    }
    public CarDto saveCar(CarDto carDto){
        Car car = CarDto.DtoToCar.apply(carDto);
        entityManager.persist(car);
        return CarDto.CarToDto.apply(car);
    }
}
