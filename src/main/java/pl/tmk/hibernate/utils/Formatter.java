package pl.tmk.hibernate.utils;

import pl.tmk.hibernate.model.Address;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatter {

    public static LocalDate localDateFromString(String localDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(localDate, dateTimeFormatter);
    }
//    public static Address addressFromString(String address){
//    }
}
