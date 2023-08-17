package dev.abs.six.controller;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.service.UserInputServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/fatburner/product")
public class ProductController {

    @Inject
    UserInputServiceImpl userInputService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProductById(String id) {
        return userInputService.getTest();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProductByName(String productName) {
        return userInputService.getTest();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO createNewProduct() {
        return userInputService.getTest();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO updateProduct() {
        return userInputService.getTest();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO deleteProduct() {
        return userInputService.getTest();
    }
}
