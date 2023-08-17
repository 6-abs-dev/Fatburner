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
    String productName;
    int ccal;
    int protein;
    int fat;
    int carb;
}
