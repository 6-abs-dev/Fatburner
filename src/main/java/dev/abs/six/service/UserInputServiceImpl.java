package dev.abs.six.service;


import dev.abs.six.model.ProductDTO;

public class UserInputServiceImpl {
    public ProductDTO getTest() {
        return ProductDTO.builder()
                .name("banata")
                .build();
    }
}
