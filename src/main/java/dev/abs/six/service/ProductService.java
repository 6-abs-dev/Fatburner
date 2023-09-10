package dev.abs.six.service;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.repository.ProductRepository;
import dev.abs.six.repository.UserInputRepository;
import dev.abs.six.repository.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    public ProductDTO getProductById(Long id) {
        return productEntityToProductDTO(productRepository.getProductById(id));
    }

    public ProductDTO getProductByName(String productName) {
        return productEntityToProductDTO(productRepository.getProductByName(productName));
    }

    public ProductDTO createNewProduct(ProductDTO productDTO) {
        return productEntityToProductDTO(productRepository.createNewProduct(productDTO));
    }


    public ProductDTO updateProduct(ProductDTO productDTO) {
        return productEntityToProductDTO(productRepository.updateProduct(productDTO));
    }

    public ProductDTO deleteProduct(Long id) {
        return productEntityToProductDTO(productRepository.deleteProduct(id));
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
