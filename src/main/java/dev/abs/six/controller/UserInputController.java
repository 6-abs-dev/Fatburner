package dev.abs.six.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/fatburner")
public class UserInputController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "Got it!";
    }
}
