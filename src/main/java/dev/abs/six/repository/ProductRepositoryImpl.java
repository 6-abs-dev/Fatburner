package dev.abs.six.repository;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.repository.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRepositoryImpl implements  ProductRepository {

    @Inject
    EntityManager entityManager;

    @Override
    public ProductEntity getProductById(Long id) {
        return this.entityManager.find(ProductEntity.class, id);
    }

    @Override
    public ProductEntity getProductByName(String productName) {
        return this.entityManager.createQuery("SELECT p FROM ProductEntity p WHERE p.productName = :productName", ProductEntity.class)
                .setParameter("productName", productName)
                .getSingleResult();
    }

    @Override
    public ProductEntity createNewProduct(ProductDTO productDTO) {
        this.entityManager.getTransaction().begin();
        ProductEntity productEntity = this.entityManager.merge(ProductEntity.builder()
                .productName(productDTO.getProductName())
                .calories(productDTO.getCalories())
                .protein(productDTO.getProtein())
                .carb(productDTO.getCarb())
                .fat(productDTO.getFat())
                .build());
        this.entityManager.getTransaction().commit();
        return productEntity;

    }

    @Override
    public ProductEntity updateProduct(ProductDTO productDTO) {
        ProductEntity productEntity = this.getProductByName(productDTO.getProductName());
        productEntity.setCarb(productDTO.getCarb());
        productEntity.setFat(productEntity.getFat());
        productEntity.setProtein(productDTO.getProtein());
        productEntity.setCalories(productEntity.getCalories());
        return entityManager.merge(productEntity);
    }

    @Override
    public ProductEntity deleteProduct(Long id) {
        ProductEntity productEntity = this.getProductById(id);
        entityManager.remove(productEntity);
        return productEntity;
    }

}
