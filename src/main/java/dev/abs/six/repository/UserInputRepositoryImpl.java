package dev.abs.six.repository;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.repository.entity.ProductEntity;

import javax.persistence.*;

public class UserInputRepositoryImpl implements UserInputRepository {

//    @PersistenceUnit(unitName = "fatburner")
//    private EntityManagerFactory entityManagerFactory;

//    @PersistenceContext(unitName = "fatburner")
//    private EntityManager entityManager;


    EntityManager entityManager = Persistence.createEntityManagerFactory("fatburner").createEntityManager();

    @Override
    public ProductDTO getTest() {

//        ProductEntity merge = entityManagerFactory.createEntityManager().merge(new ProductEntity(1L, "oat"));



        ProductEntity merge = entityManager.merge(new ProductEntity(2L, "oat2"));

        return ProductDTO.builder()
                .name(merge.getName())
                .build();
    }
}
