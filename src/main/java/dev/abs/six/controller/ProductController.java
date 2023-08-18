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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProductById(@PathParam("id") Long id) {
        return userInputService.getProductById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProductByName(@QueryParam(value = "productName") String productName) {
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO deleteProduct(@PathParam(value = "id") Long id) {
        return userInputService.deleteProduct(id);
    }
}
