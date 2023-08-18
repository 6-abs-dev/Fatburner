package dev.abs.six.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column
    private String productName;
    @Column
    private Double calories;
    @Column
    private Double protein;
    @Column
    private Double fat;
    @Column
    private Double carb;
}
