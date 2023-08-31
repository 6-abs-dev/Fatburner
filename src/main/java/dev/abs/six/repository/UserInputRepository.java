package dev.abs.six.repository;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.model.UserInputDTO;
import dev.abs.six.repository.entity.ProductEntity;
import dev.abs.six.repository.entity.UserInputEntity;

public interface UserInputRepository {

    ProductEntity getProductById(Long id);

    ProductEntity getProductByName(String productName);

    ProductEntity createNewProduct(ProductDTO productDTO);

    ProductEntity updateProduct(ProductDTO productDTO);

    ProductEntity deleteProduct(Long id);

    UserInputEntity putInputProduct(UserInputDTO userInputDTO);

    UserInputEntity getInputByDate(String date);

    UserInputEntity updateInputProduct(UserInputDTO userInputDTO);

    void deleteEntireInputForSpecificDay(String date);
}
