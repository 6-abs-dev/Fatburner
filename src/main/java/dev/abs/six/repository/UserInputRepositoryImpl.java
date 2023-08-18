package dev.abs.six.repository;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.repository.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Data
public class UserInputRepositoryImpl implements UserInputRepository {

    EntityManager entityManager;

    public UserInputRepositoryImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("fatburner").createEntityManager();
    }

    @Override
    public ProductEntity getProductById(String id) {
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
        return this.entityManager.merge(ProductEntity.builder()
                .productName(productDTO.getProductName())
                .ccal(productDTO.getCcal())
                .protein(productDTO.getProtein())
                .carbs(productDTO.getCarb())
                .fat(productDTO.getFat())
                .build());
    }

    @Override
    public ProductEntity updateProduct(ProductDTO productDTO) {
        ProductEntity productEntity = this.getProductByName(productDTO.getProductName());
        productEntity.setCarbs(productDTO.getCarb());
        productEntity.setFat(productEntity.getFat());
        productEntity.setProtein(productDTO.getProtein());
        productEntity.setCcal(productEntity.getCcal());
        return entityManager.merge(productEntity);
    }

    @Override
    public ProductEntity deleteProduct(String id) {
        ProductEntity productEntity = this.getProductById(id);
        entityManager.remove(productEntity);
        return productEntity;
    }
}
