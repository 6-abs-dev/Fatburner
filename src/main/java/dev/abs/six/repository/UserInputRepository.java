package dev.abs.six.repository;

import dev.abs.six.model.ProductDTO;

public interface UserInputRepository {
    ProductDTO saveNewInput(ProductDTO productDTO);
}
