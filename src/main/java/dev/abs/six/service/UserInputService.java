package dev.abs.six.service;


import dev.abs.six.model.ProductDTO;
import dev.abs.six.repository.UserInputRepository;
import dev.abs.six.repository.UserInputRepositoryImpl;
import dev.abs.six.repository.entity.ProductEntity;

import java.util.List;

public class UserInputService {
    private final UserInputRepository userInputRepository = new UserInputRepositoryImpl();

    public ProductDTO getProductById(Long id) {
        return productEntityToProductDTO(userInputRepository.getProductById(id));
    }

    public ProductDTO getProductByName(String productName) {
        return productEntityToProductDTO(userInputRepository.getProductByName(productName));
    }

    public ProductDTO createNewProduct(ProductDTO productDTO) {
        return productEntityToProductDTO(userInputRepository.createNewProduct(productDTO));
    }



    public ProductDTO updateProduct(ProductDTO productDTO) {
        return productEntityToProductDTO(userInputRepository.updateProduct(productDTO));
    }

    public ProductDTO deleteProduct(Long id) {
        return productEntityToProductDTO(userInputRepository.deleteProduct(id));
    }

    public ProductDTO getListForSpecificDay(String date) {
        return null;
    }

    public ProductDTO getListForPeriod() {
        return null;
    }

    public ProductDTO putProduct(ProductDTO productDTO) {
        return null;
    }

    public ProductDTO putProductBatch(List<ProductDTO> listOfProducts) {
        return null;
    }

    public ProductDTO updateDailyList(List<ProductDTO> listOfProducts) {
        return null;
    }

    private static ProductDTO productEntityToProductDTO(ProductEntity product) {
        return ProductDTO.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .calories(product.getCalories())
                .protein(product.getProtein())
                .fat(product.getFat())
                .carb(product.getCarb())
                .build();
    }
}
