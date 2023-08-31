package dev.abs.six.controller;


import dev.abs.six.model.UserInputDTO;
import dev.abs.six.service.UserInputService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;


@Path("/fatburner/user_input")
public class UserInputController {
//    private Logger logger = Logger.getLogger(this.getClass());
    @Inject
    UserInputService userInputService;

    @GET
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserInputDTO getListForSpecificDay(@PathParam("date") String date) {
//        logger.info(">>>request from getUserInput");
        //TODO make users support;
        String userName;
        return userInputService.getListForSpecificDay(date);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public UserInputDTO putInputProduct(UserInputDTO userInputDTO) {
        return userInputService.putInputProduct(userInputDTO);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UserInputDTO updateInputProduct(UserInputDTO userInputDTO) {
        return userInputService.updateInputProduct(userInputDTO);
    }

    @DELETE
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public UserInputDTO deleteSingleInput(UserInputDTO userInputDTO) {
        //TODO make users support;
        String userName = "maksim";
        return userInputService.deleteSingleInput(userInputDTO);
    }

    @DELETE
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteEntireInputForSpecificDay(@PathParam("date") String date) {
        //TODO make users support;
        String userName = "maksim";
        userInputService.deleteEntireInputForSpecificDay(date);
        return "Deletion complete.";
    }

}
