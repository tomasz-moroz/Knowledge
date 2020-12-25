package pl.knowledge.yt_podstawyJUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import pl.knowledge.yt_podstawyJUnit.other.OtherWorkshopCarDetailsDTO;
import pl.knowledge.yt_podstawyJUnit.other.OtherWorkshopCarDetailsService;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

class CarDetailsConverterTest {

    private CarDetailsConverter carDetailsConverter;

    private OtherWorkshopCarDetailsDTO createMock(Integer id, Integer treadThickness, Integer fuelUsage, Integer carMillage) {

        OtherWorkshopCarDetailsDTO mock = Mockito.mock(OtherWorkshopCarDetailsDTO.class);
        Mockito.when(mock.getId()).thenReturn(id);
        Mockito.when(mock.getCarMillage()).thenReturn(treadThickness);
        Mockito.when(mock.getFuelUsage()).thenReturn(fuelUsage);
        Mockito.when(mock.getTreadThickness()).thenReturn(carMillage);
        return mock;
    }
    private OtherWorkshopCarDetailsService createServiceMock(){
        OtherWorkshopCarDetailsService service = Mockito.mock(OtherWorkshopCarDetailsService.class);
        List<OtherWorkshopCarDetailsDTO>dbContent = dbContent();
        Mockito.when(service.findCarDetailsToAnalyze()).thenReturn(dbContent);
        return service;
    }

    private List<OtherWorkshopCarDetailsDTO>dbContent(){
        return Arrays.asList(createMock(1,3,4,5),
                createMock(2,5,6,3));
    }

    @Test
     void convert_simpleCase_convertSuccess(){
        //given
        carDetailsConverter = new CarDetailsConverter(null);
        OtherWorkshopCarDetailsDTO itemToTest = createMock(1,10,6,3);
        //when
        CarDetails carDetails = carDetailsConverter.convert(itemToTest);
        //then
        Assertions.assertEquals(carDetails.getId(), "1");
        Assertions.assertEquals(carDetails.getCarMillage(), Integer.valueOf(10));
        Assertions.assertEquals(carDetails.getFuelUsage(), Integer.valueOf(6));
        Assertions.assertEquals(carDetails.getTreadThickness(), Integer.valueOf(3));
    }

    @Test
    void convertAll_simpleCase_convertSuccess(){
        //given
        OtherWorkshopCarDetailsService service = createServiceMock();
        carDetailsConverter = new CarDetailsConverter(service);
        //then
        List<CarDetails>result = carDetailsConverter.convertAll();
        //when
        Assertions.assertEquals(result.size(), 2);
        Assertions.assertEquals(result.size(), 2);
    }

}