package pl.knowledge.controller;

import pl.knowledge.dto.PersonDto;
import pl.knowledge.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    @Inject
    PersonService personService;

    @POST
    public PersonDto savePerson(PersonDto personDTO) {
        personService.savePerson(personDTO);
        return personDTO;

    }

    @Path("/{id}")
    @GET
    public Response getPersonById(@PathParam("id") Integer id) {
        return Response.ok(personService.getPersonById(id)).build();
    }

    @Path("/{id}")
    @PUT
    //tu widać, że to jest coś co bierze sobie z requestu z przeglądarki, nie?
    //dlatego personDTO jest brane od użytkownika z JSONA.
    public PersonDto update(@PathParam("id") Integer id, PersonDto personDTO) {
        personService.update(id, personDTO);
        return personService.getPersonById(id);
    }

    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") Integer id) {
        personService.delete(id);
        return Response.noContent().build();
    }

}
