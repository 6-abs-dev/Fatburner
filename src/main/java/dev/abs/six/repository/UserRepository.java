package dev.abs.six.repository;

import dev.abs.six.model.UserDTO;
import dev.abs.six.repository.entity.UserEntity;

import java.util.List;

public interface UserRepository {

    UserEntity createNewUser(UserDTO userDTO);
    UserEntity getUserByLogin(String login);
    List<UserEntity> getAllUsers();
    UserEntity updateUser(UserDTO userDTO);
    void deleteUser(String login);


}
