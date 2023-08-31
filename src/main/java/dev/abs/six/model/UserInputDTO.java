package dev.abs.six.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserInputDTO {

    private LocalDate timeOfInput;
    private String userName;
    private List<SingleProductInputDTO> productInputList;

}
