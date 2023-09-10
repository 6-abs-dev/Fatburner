package dev.abs.six.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {
    private String login;
    private String firstName;
    private String secondName;
    private Double weight;
    private Double height;
}
