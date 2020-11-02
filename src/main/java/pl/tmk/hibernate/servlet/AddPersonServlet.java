package pl.tmk.hibernate.servlet;

import pl.tmk.hibernate.dto.AddressDto;
import pl.tmk.hibernate.dto.AnimalDto;
import pl.tmk.hibernate.dto.CarDto;
import pl.tmk.hibernate.dto.PersonDto;
import pl.tmk.hibernate.enums.Brand;
import pl.tmk.hibernate.enums.Species;
import pl.tmk.hibernate.model.Address;
import pl.tmk.hibernate.service.AddressService;
import pl.tmk.hibernate.service.AnimalService;
import pl.tmk.hibernate.service.CarService;
import pl.tmk.hibernate.service.PersonService;
import pl.tmk.hibernate.utils.Formatter;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/person")
public class AddPersonServlet extends HttpServlet {

    @Inject
    PersonService personService;

    @Inject
    CarService carService;

    @Inject
    AddressService addressService;

    @Inject
    AnimalService animalService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        LocalDate birthDate = Formatter.localDateFromString(request.getParameter("birthDate"));

        Brand brand = Brand.valueOf(request.getParameter("brand"));
        String model = request.getParameter("model");

        String city = request.getParameter("city");
        Integer zip = Integer.valueOf(request.getParameter("zip"));
        String street = request.getParameter("street");
        String houseNumber = request.getParameter("houseNumber");
        String apartmentNumber = request.getParameter("apartmentNumber");

        String animalName = request.getParameter("animalName");
        Species species = Species.valueOf(request.getParameter("species"));

        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setLastName(lastName);
        personDto.setBirthDay(birthDate);

        CarDto carDto = new CarDto();
        carDto.setBrand(brand);
        carDto.setModel(model);

        AddressDto addressDto = new AddressDto();
        addressDto.setCity(city);
        addressDto.setZip(zip);
        addressDto.setStreet(street);
        addressDto.setHouseNumber(houseNumber);
        addressDto.setApartmentNumber(apartmentNumber);

        AnimalDto animalDto = new AnimalDto();
        animalDto.setName(animalName);
        animalDto.setSpecies(species);

        personService.savePerson(personDto);
        carService.saveCar(carDto);
        animalService.saveAnimal(animalDto);
        addressService.saveAddress(addressDto);

        PrintWriter printWriter = response.getWriter();
        printWriter.println(String.format("Person saved: %s", personDto.toString()));
    }
}
