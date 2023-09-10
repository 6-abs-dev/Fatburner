package dev.abs.six.controller;

import dev.abs.six.model.UserDTO;
import dev.abs.six.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/fatburner/user")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUserByLogin(@PathParam("id") String id) {
        return userService.getUserByLogin(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO createNewProduct(UserDTO userDTO) {
        return userService.createNewUser(userDTO);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO updateUser(UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteProduct(@PathParam(value = "id") String id) {
        userService.deleteUser(id);
        return "Deletion complete.";
    }
}
