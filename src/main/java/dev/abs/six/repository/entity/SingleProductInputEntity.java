package dev.abs.six.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "single_product_input")
public class SingleProductInputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productId;
    @Column(name = "input_id")
    private Long inputId;
    private double quantity;
    //TODO make enum
    private String measure = "gram";

}
