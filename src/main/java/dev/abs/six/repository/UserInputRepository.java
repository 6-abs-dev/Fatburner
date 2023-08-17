package dev.abs.six.repository;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.repository.entity.ProductEntity;

public interface UserInputRepository {

    ProductEntity getProductById(String id);

    ProductEntity getProductByName(String productName);

    ProductEntity createNewProduct(ProductDTO productDTO);

    ProductEntity updateProduct(ProductDTO productDTO);

    ProductEntity deleteProduct(String id);
}
