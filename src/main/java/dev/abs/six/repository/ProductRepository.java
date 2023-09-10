package dev.abs.six.repository;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.repository.entity.ProductEntity;

public interface ProductRepository {
    ProductEntity getProductById(Long id);

    ProductEntity getProductByName(String productName);

    ProductEntity createNewProduct(ProductDTO productDTO);

    ProductEntity updateProduct(ProductDTO productDTO);

    ProductEntity deleteProduct(Long id);
}
