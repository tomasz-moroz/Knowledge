package pl.knowledge.yt_podstawyJUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestNGCarServiceTest {

    private CarDetails createCarDetails(String id, Integer treadThickness, Integer fuelUsage, Integer carMillage) {
        CarDetails carDetails = new CarDetails();
        carDetails.setId(id);
        carDetails.setTreadThickness(treadThickness);
        carDetails.setFuelUsage(fuelUsage);
        carDetails.setCarMillage(carMillage);
        return carDetails;
    }

    private List<CarDetails> carDetailsList() {
        List<CarDetails> carDetailsList = new ArrayList<>();
        carDetailsList.add(createCarDetails("1", 3, 4, 1000));
        carDetailsList.add(createCarDetails("2", 2, 4000, 5000));
        carDetailsList.add(createCarDetails("3", 4, 4, 3000));
        carDetailsList.add(createCarDetails("4", 3, 4, 8000));
        return carDetailsList;
    }

    private List<CarDiagnosticResult>createExpectedResults(){
        List<CarDiagnosticResult> results = new ArrayList<>();
        results.add(new CarDiagnosticResult("1",true));
        results.add(new CarDiagnosticResult("2",false));
        results.add(new CarDiagnosticResult("3",true));
        results.add(new CarDiagnosticResult("4",true));
        return results;
    }

    @Test
    void test(){
        //given
        List<CarDetails>carDetailsList = carDetailsList();
        CarService carService = new CarService();
        //when
        List<CarDiagnosticResult> results = carService.analyzeCars(carDetailsList);
        //then
        Assert.assertEquals(results, createExpectedResults());
    }
}
