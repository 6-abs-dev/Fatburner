package dev.abs.six.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SingleProductInputDTO {
    //TODO Nullable - make validator
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long singleInputId;
    private Long productId;
    private double quantity;
    //TODO make enum
    private String measure;

}
