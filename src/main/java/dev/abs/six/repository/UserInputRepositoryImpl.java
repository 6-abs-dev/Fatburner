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
    public ProductDTO saveNewInput(ProductDTO productDTO) {

        ProductEntity productEntity = entityManager.merge(ProductEntity.builder()
                .productName(productDTO.getProductName())
                .ccal(productDTO.getCcal())
                .protein(productDTO.getProtein())
                .fat(productDTO.getFat())
                .carbs(productDTO.getCarb())
                .build());

        return ProductDTO.builder()
                .productName(productEntity.getProductName())
                .ccal(productDTO.getCcal())
                .protein(productEntity.getProtein())
                .fat(productEntity.getFat())
                .carb(productEntity.getCarbs())
                .build();
    }
}
