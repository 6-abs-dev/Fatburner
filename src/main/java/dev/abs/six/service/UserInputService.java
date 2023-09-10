package dev.abs.six.service;


import dev.abs.six.model.SingleProductInputDTO;
import dev.abs.six.model.UserInputDTO;
import dev.abs.six.repository.UserInputRepository;
import dev.abs.six.repository.entity.UserInputEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInputService {
    @Inject
    private UserInputRepository userInputRepository;

    //User inputs
    public UserInputDTO getListForSpecificDay(String date) {
        UserInputEntity userInputEntity = userInputRepository.getInputByDate(date);

        return userUnputEntityToDTO(userInputEntity);
    }

    public UserInputDTO putInputProduct(UserInputDTO userInputDTO) {
        UserInputEntity userInputEntity = userInputRepository.putInputProduct(userInputDTO);
        return userUnputEntityToDTO(userInputEntity);
    }

    public UserInputDTO updateInputProduct(UserInputDTO userInputDTO) {
        UserInputEntity userInputEntity = userInputRepository.updateInputProduct(userInputDTO);

        return userUnputEntityToDTO(userInputEntity);
    }

    public UserInputDTO deleteSingleInput(UserInputDTO userInputDTO) {
        UserInputEntity userInputEntity = userInputRepository.deleteSingleInput(userInputDTO);

        return userUnputEntityToDTO(userInputEntity);
    }


    public void deleteEntireInputForSpecificDay(String date) {
        userInputRepository.deleteEntireInputForSpecificDay(date);
    }

    private UserInputDTO userUnputEntityToDTO(UserInputEntity userInputEntity) {
        return UserInputDTO.builder()
                .timeOfInput(userInputEntity.getDate())
                .productInputList(
                        userInputEntity.getProducts().stream()
                                .map(singleProductInputEntity -> SingleProductInputDTO.builder()
                                        .singleInputId(singleProductInputEntity.getSingleProductInputId())
                                        .productId(singleProductInputEntity.getProductId())
                                        .measure(singleProductInputEntity.getMeasure())
                                        .quantity(singleProductInputEntity.getQuantity())
                                        .build()
                                )
                                .collect(Collectors.toList()))
                .build();
    }
}
