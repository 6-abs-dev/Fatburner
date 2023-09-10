package dev.abs.six.repository;

import dev.abs.six.model.UserDTO;
import dev.abs.six.repository.entity.UserEntity;

public interface UserRepository {

    UserEntity createNewUser(UserDTO userDTO);
    UserEntity getUserByLogin(String login);
    UserEntity updateUser(UserDTO userDTO);
    void deleteUser(String login);
}
