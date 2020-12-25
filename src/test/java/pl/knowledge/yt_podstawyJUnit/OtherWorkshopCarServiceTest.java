package pl.knowledge.yt_podstawyJUnit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OtherWorkshopCarServiceTest {

    private CarService mockCarService() {
        CarService carService = Mockito.mock(CarService.class);
        return carService;
    }

    private CarDetailsConverter mockCarDetailsConverter(List<CarDetails> carDetailsList) {
        CarDetailsConverter carDetailsConverter = Mockito.mock(CarDetailsConverter.class);
        Mockito.when(carDetailsConverter.convertAll()).thenReturn(carDetailsList);
        return carDetailsConverter;
    }


    @Test
    void analyzeOtherWorkshopCars_basicCase_success() {
        //given
        List<CarDetails>carDetails = new ArrayList<>();
        CarService carService = mockCarService();
        CarDetailsConverter carDetailsConverter = mockCarDetailsConverter(carDetails);
        OtherWorkshopCarService otherWorkshopCarService = new OtherWorkshopCarService(carService, carDetailsConverter);
        //when
        otherWorkshopCarService.analyzeOtherWorkshopCars();
        //then
        Mockito.verify(carService).analyzeCars(carDetails);
    }

}