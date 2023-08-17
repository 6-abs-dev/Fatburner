package dev.abs.six.controller;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.service.UserInputService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/fatburner/product")
public class ProductController {

    @Inject
    UserInputService userInputService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProductById(String id) {
        return userInputService.getProductById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProductByName(String productName) {
        return userInputService.getProductByName(productName);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO createNewProduct(ProductDTO productDTO) {
        return userInputService.createNewProduct(productDTO);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO updateProduct(ProductDTO productDTO) {
        return userInputService.updateProduct(productDTO);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO deleteProduct(String id) {
        return userInputService.deleteProduct(id);
    }
}
