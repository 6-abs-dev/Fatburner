package dev.abs.six.controller;

import dev.abs.six.service.UserInputService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/fatburner")
public class UserInputController {

    @Inject
    UserInputService userInputService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return userInputService.getTest();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return userInputService.getTest();
    }
}
