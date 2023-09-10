package dev.abs.six.service;

import dev.abs.six.model.UserDTO;
import dev.abs.six.repository.UserRepository;
import dev.abs.six.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserService {

    @Inject
    private UserRepository userRepository;

    public UserDTO createNewUser(UserDTO userDTO) {
        return userEntityToUserDTO(userRepository.createNewUser(userDTO));
    }

    public UserDTO getUserByLogin(String login) {
        return userEntityToUserDTO(userRepository.getUserByLogin(login));
    }

    public UserDTO updateUser(UserDTO userDTO) {
        return userEntityToUserDTO(userRepository.updateUser(userDTO));
    }

    public void deleteUser(String login){
        userRepository.deleteUser(login);
    }

    private UserDTO userEntityToUserDTO(UserEntity userEntity) {
        return UserDTO.builder()
                .login(userEntity.getLogin())
                .firstName(userEntity.getFirstName())
                .secondName(userEntity.getSecondName())
                .height(userEntity.getHeight())
                .weight(userEntity.getWeight())
                .build();
    }
}
