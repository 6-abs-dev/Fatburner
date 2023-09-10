package dev.abs.six.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private String login;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    private Double weight;
    private Double height;
}
