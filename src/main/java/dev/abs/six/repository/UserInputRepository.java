package dev.abs.six.repository;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.model.UserInputDTO;
import dev.abs.six.repository.entity.ProductEntity;
import dev.abs.six.repository.entity.UserInputEntity;

public interface UserInputRepository {

    UserInputEntity putInputProduct(UserInputDTO userInputDTO);

    UserInputEntity getInputByDate(String date);

    UserInputEntity updateInputProduct(UserInputDTO userInputDTO);

    UserInputEntity deleteSingleInput(UserInputDTO userInputDTO);

    void deleteEntireInputForSpecificDay(String date);
}
