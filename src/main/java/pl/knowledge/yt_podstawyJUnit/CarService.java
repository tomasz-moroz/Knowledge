package pl.knowledge.yt_podstawyJUnit;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public boolean analyzeCarByParams(Integer threadThickness, Integer fuelUsage, Integer carMillage){

        boolean millageNull = null == carMillage;
        boolean fuelUsageNull = null == fuelUsage;
        boolean threadThicknessNull = null == threadThickness;

        if(millageNull || fuelUsageNull || threadThicknessNull){
            throw new IllegalArgumentException("Car details can not by null");
        }
        boolean isMillageCorrect = isCorrect(carMillage, ParamValues.CAR_MILLAGE);
        boolean isFuelUsageCorrect = isCorrect(fuelUsage, ParamValues.FUEL_USAGE);
        boolean isThreadThicknessCorrect = isCorrect(fuelUsage, ParamValues.THREAD_THICKNESS);

        if(isFuelUsageCorrect && isMillageCorrect && isThreadThicknessCorrect){
            return true;
        }
        return false;
    }

    private boolean isCorrect(Integer value, ParamValues validValues){

        if(value<0){
            throw   new IllegalArgumentException("Incorrect value");
        }

        Integer maxValue = validValues.getMaxValue();
        Integer minValue = validValues.getMinValue();

        if(value > minValue && value < maxValue){
            return true;
        }
        return false;
    }

    public List<CarDiagnosticResult> analyzeCars(List<CarDetails> carsDetails) {

        List<CarDiagnosticResult> results = new ArrayList<>();
        carsDetails.forEach(details -> {

            boolean analyzeResult = analyzeSingle(details);
            results.add(new CarDiagnosticResult(details.getId(), analyzeResult));
        });
        return results;
    }

    private boolean analyzeSingle(CarDetails carDetails) {

        Integer treadThickness = carDetails.getTreadThickness();
        Integer fuelUsage = carDetails.getFuelUsage();
        Integer carMillage = carDetails.getCarMillage();
        return analyzeCarByParams(treadThickness, fuelUsage, carMillage);
    }
}
