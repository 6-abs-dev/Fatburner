package dev.abs.six.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user_input")
public class UserInputEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private LocalDate date;

    @OneToMany(mappedBy = "inputId", cascade = CascadeType.REMOVE) //здесь указывается поле обьекта а не базы данных
    private List<SingleProductInputEntity> products;


}
