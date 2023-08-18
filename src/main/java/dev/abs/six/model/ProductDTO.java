package dev.abs.six.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductDTO {
    Long productId;
    String productName;
    Double calories;
    Double protein;
    Double fat;
    Double carb;
}
