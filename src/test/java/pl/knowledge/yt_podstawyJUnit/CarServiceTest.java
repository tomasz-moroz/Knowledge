package pl.knowledge.yt_podstawyJUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    private static Stream<Arguments>data(){
        return Stream.of(Arguments.of(3,5,1500,true),
                Arguments.of(3,5,21000,false),
                Arguments.of(2,14,0,false));
    }
    @ParameterizedTest
    @MethodSource("data")
    void analyzeCarByParams_withDataFromMethod_resultFromData(Integer threadThickness, Integer fuelUsage, Integer carMillage, boolean expectedResult) {
        //given
        CarService carService = new CarService();
        //when
        boolean result = carService.analyzeCarByParams(threadThickness, fuelUsage, carMillage);
        //then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void analyzeCarByParams_millageNull_throwsIllegalArgumentException() {
        //given
        Integer threadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = null;
        CarService carService = new CarService();

        //when
        /*carService.analyzeCarByParams(threadThickness, fuelUsage, carMillage);*/
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> carService.analyzeCarByParams(threadThickness, fuelUsage, carMillage));
    }

    @Test
    void analyzeCarByParams_allValuesCorrect_resultTrue() {
        //given
        Integer threadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = 10000;
        CarService carService = new CarService();
        //when
        boolean result = carService.analyzeCarByParams(threadThickness, fuelUsage, carMillage);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    void analyzeCarByParams_wrongNegativeFuelUsage_resultThrowsIllegalArgumentException() {
        //given
        Integer threadThickness = 3;
        Integer fuelUsage = -2;
        Integer carMillage = 10000;
        CarService carService = new CarService();
        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> carService.analyzeCarByParams(threadThickness, fuelUsage, carMillage));
    }
    @Test
    void analyzeCarByParams_CarMillageToHigh_resultFalse() {
        //given
        Integer threadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = 210000;
        CarService carService = new CarService();
        //when
        boolean result = carService.analyzeCarByParams(threadThickness, fuelUsage, carMillage);
        //then
        Assertions.assertFalse(result);
    }

}