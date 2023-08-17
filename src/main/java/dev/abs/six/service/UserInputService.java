package dev.abs.six.service;


import dev.abs.six.model.ProductDTO;
import dev.abs.six.repository.UserInputRepository;
import dev.abs.six.repository.UserInputRepositoryImpl;

public class UserInputService {
    private final UserInputRepository userInputRepository = new UserInputRepositoryImpl();

    public ProductDTO getProductById(String id) {
        userInputRepository.getProductById(id);
        return null;
    }

    public ProductDTO getProductByName(String productName) {
        userInputRepository.getProductByName(productName);
        return null;
    }

    public ProductDTO createNewProduct(ProductDTO productDTO) {
        userInputRepository.createNewProduct(productDTO);
        return null;
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        userInputRepository.updateProduct(productDTO);
        return null;
    }

    public ProductDTO deleteProduct(String id) {
        userInputRepository.deleteProduct(id);
        return null;
    }
}
