package dev.abs.six.controller;

import dev.abs.six.model.ProductDTO;
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
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public ProductDTO getListForSpecificDay(String date) {
//        return userInputService.getListForSpecificDay(date);
//    }
//
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getListForPeriod() {
        return userInputService.getListForPeriod();
    }
//
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public ProductDTO putProduct(ProductDTO productDTO) {
//        return userInputService.putProduct(productDTO);
//    }
//
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public ProductDTO putProductBatch(List<ProductDTO> listOfProducts) {
//        return userInputService.putProductBatch(listOfProducts);
//    }
//
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public ProductDTO updateDailyList(List<ProductDTO> listOfProducts) {
//        return userInputService.updateDailyList(listOfProducts);
//    }
}
