package dev.abs.six.service;


import dev.abs.six.model.ProductDTO;
import dev.abs.six.model.SingleProductInputDTO;
import dev.abs.six.model.UserInputDTO;
import dev.abs.six.repository.UserInputRepository;
import dev.abs.six.repository.entity.ProductEntity;
import dev.abs.six.repository.entity.UserInputEntity;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class UserInputService {


    private UserInputRepository userInputRepository;

    @Inject
    public UserInputService(UserInputRepository userInputRepository) {
        this.userInputRepository = userInputRepository;
    }

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

    //User inputs
    public UserInputDTO getListForSpecificDay(String date) {
        return null;
    }

    public UserInputDTO putInputProduct(UserInputDTO userInputDTO) {
        UserInputEntity userInputEntity = userInputRepository.putInputProduct(userInputDTO);

        return UserInputDTO.builder()
                .timeOfInput(userInputEntity.getDate())
                .productInputList(userInputEntity.getProducts().stream()
                        .map(singleProductInputEntity -> SingleProductInputDTO.builder()
                                .productId(singleProductInputEntity.getProductId())
                                .measure(singleProductInputEntity.getMeasure())
                                .quantity(singleProductInputEntity.getQuantity())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
