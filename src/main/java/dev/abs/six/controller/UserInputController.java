package dev.abs.six.controller;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.model.UserInputDTO;
import dev.abs.six.service.UserInputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;


@Path("/fatburner/user_input")
public class UserInputController {
    private static Logger logger = LoggerFactory.getLogger(UserInputController.class);

    @Inject
    UserInputService userInputService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserInputDTO getListForSpecificDay() {
        System.out.println("!!!WE ARE HERE!");
        logger.info(">>>request from getUserInput");
        String date = LocalDate.now().toString();
        return userInputService.getListForSpecificDay(date);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UserInputDTO putInputProduct(UserInputDTO userInputDTO) {
        return userInputService.putInputProduct(userInputDTO);
    }

}
