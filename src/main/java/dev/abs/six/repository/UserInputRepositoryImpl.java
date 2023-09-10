package dev.abs.six.repository;

import dev.abs.six.model.ProductDTO;
import dev.abs.six.model.SingleProductInputDTO;
import dev.abs.six.model.UserInputDTO;
import dev.abs.six.repository.entity.ProductEntity;
import dev.abs.six.repository.entity.SingleProductInputEntity;
import dev.abs.six.repository.entity.UserInputEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserInputRepositoryImpl implements UserInputRepository {
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

    @Override
    public UserInputEntity putInputProduct(UserInputDTO userInputDTO) {

        List<SingleProductInputDTO> productInputsList = userInputDTO.getProductInputList();

        String inputId = UUID.nameUUIDFromBytes((userInputDTO.getTimeOfInput() + "maksim").getBytes()).toString();

        entityManager.getTransaction().begin();
        List<SingleProductInputEntity> singleProductInputEntities = productInputsList.stream()
                .map(singleProductInputDTO -> entityManager.merge(SingleProductInputEntity.builder()
                        .productId(singleProductInputDTO.getProductId())
                        .inputId(inputId)
                        .measure(singleProductInputDTO.getMeasure())
                        .quantity(singleProductInputDTO.getQuantity())
                        .build()))
                .collect(Collectors.toList());

        UserInputEntity userInputEntity = entityManager.merge(UserInputEntity.builder()
                .id(inputId)
                .userName("maksim")
                .date(userInputDTO.getTimeOfInput())
                .products(singleProductInputEntities)
                .build());

        entityManager.getTransaction().commit();
        return userInputEntity;
    }

    @Override
    public UserInputEntity getInputByDate(String date) {
        //TODO refactor

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.getDefault());

        String inputId = UUID.nameUUIDFromBytes((LocalDate.parse(date, formatter) + "maksim").getBytes()).toString();
        String userName = "maksim";

        return entityManager.find(UserInputEntity.class, inputId);
//        return entityManager.createQuery("SELECT uie FROM UserInputEntity uie WHERE uie.date = :date AND uie.userName = :userName", UserInputEntity.class)
//                .setParameter("date", date)
//                .setParameter("userName", userName)
//                .getSingleResult();
    }

    @Override
    public UserInputEntity updateInputProduct(UserInputDTO userInputDTO) {
        entityManager.getTransaction().begin();
        UserInputEntity userInputEntity = this.getInputByDate(userInputDTO.getTimeOfInput().toString());
        List<SingleProductInputEntity> products = userInputEntity.getProducts();
        List<SingleProductInputEntity> newSingleProductInputEntities = userInputDTO.getProductInputList().stream()
                .map(productInputDTO -> entityManager.merge(SingleProductInputEntity.builder()
                        .productId(productInputDTO.getProductId())
                        .quantity(productInputDTO.getQuantity())
                        .measure(productInputDTO.getMeasure())
                        .inputId(userInputEntity.getId())
                        .build()))
                .collect(Collectors.toList());
        products.addAll(newSingleProductInputEntities);
        UserInputEntity userInputEntity1 = entityManager.merge(userInputEntity);
        entityManager.getTransaction().commit();
        return userInputEntity1;
    }

    @Override
    public UserInputEntity deleteSingleInput(UserInputDTO userInputToDeleteDTO) {
        entityManager.getTransaction().begin();
        UserInputEntity userInputEntity = this.getInputByDate(userInputToDeleteDTO.getTimeOfInput().toString());

        List<Long> singelInputsIds = userInputToDeleteDTO.getProductInputList().stream()
                .map(SingleProductInputDTO::getSingleInputId)
                .collect(Collectors.toList());

        List<SingleProductInputEntity> singleProductInputEntities = userInputEntity.getProducts().stream()
                .filter(singleProductInputEntity -> !singelInputsIds.contains(singleProductInputEntity.getSingleProductInputId()))
                .collect(Collectors.toList());
        userInputEntity.setProducts(singleProductInputEntities);

        UserInputEntity userInputEntity1 = entityManager.merge(userInputEntity);
        entityManager.getTransaction().commit();
        return userInputEntity1;
    }

    @Override
    public void deleteEntireInputForSpecificDay(String date) {
        UserInputEntity userInputEntity = this.getInputByDate(date);
        entityManager.remove(userInputEntity);
    }
}
