package dev.abs.six.controller;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.model.UserInputDTO;
import dev.abs.six.service.UserInputService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/fatburner/user")
public class UserInputController {

    @Inject
    UserInputService userInputService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserInputDTO getListForSpecificDay(String date) {
        return userInputService.getListForSpecificDay(date);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UserInputDTO putInputProduct(UserInputDTO userInputDTO) {
        return userInputService.putInputProduct(userInputDTO);
    }

}
