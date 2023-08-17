package dev.abs.six.controller;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.service.UserInputServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/fatburner/user")
public class UserInputController {

    @Inject
    UserInputServiceImpl userInputService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getIt() {
        return userInputService.getTest();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO test() {
        return userInputService.getTest();
    }
}
