package dev.abs.six.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SingleProductInputDTO {

    private Long productId;
    private double quantity;
    //TODO make enum
    private String measure;

}
