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
@IdClass(UserInputId.class)
public class UserInputEntity {
    @Id
    private LocalDate date;
    @Id
    private String userName;

    //TODO change to UUID
    @Column(name = "input_id")
    private String inputId;

    @OneToMany(mappedBy = "inputId", cascade = CascadeType.REMOVE) //здесь указывается поле обьекта а не базы данных
    private List<SingleProductInputEntity> products;


}
