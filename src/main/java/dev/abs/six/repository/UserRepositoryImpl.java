package dev.abs.six.repository;

import dev.abs.six.model.UserDTO;
import dev.abs.six.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRepositoryImpl implements UserRepository {

    @Inject
    EntityManager entityManager;

    @Override
    public UserEntity createNewUser(UserDTO userDTO) {
        entityManager.getTransaction().begin();
        UserEntity userEntity = entityManager.merge(UserEntity.builder()
                .login(userDTO.getLogin())
                .firstName(userDTO.getFirstName())
                .secondName(userDTO.getSecondName())
                .height(userDTO.getHeight())
                .weight(userDTO.getWeight())
                .build());

        entityManager.getTransaction().commit();
        return userEntity;
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        return entityManager.createQuery("SELECT u FROM UserEntity u where u.login = :login", UserEntity.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
                .getResultList();
    }

    @Override
    public UserEntity updateUser(UserDTO userDTO) {
        entityManager.getTransaction().begin();
        UserEntity userEntity = this.getUserByLogin(userDTO.getLogin());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setSecondName(userDTO.getSecondName());
        userEntity.setHeight(userDTO.getHeight());
        userEntity.setWeight(userDTO.getWeight());
        entityManager.getTransaction().commit();
        return userEntity;
    }

    @Override
    public void deleteUser(String login) {
        entityManager.remove(this.getUserByLogin(login));
    }
}
