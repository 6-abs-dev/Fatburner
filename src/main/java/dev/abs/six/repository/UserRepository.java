package dev.abs.six.repository;

import dev.abs.six.model.UserDTO;
import dev.abs.six.repository.entity.UserEntity;

public interface UserRepository {

    UserEntity createNewUser(UserDTO userDTO);
    UserEntity getUserById(String userId);
    UserEntity updateUser(UserDTO userDTO);
    UserEntity deleteUser(String userId);
}
