package net.aspanc.bootcamp.springmvc.dtos;

import lombok.Data;
import net.aspanc.bootcamp.springmvc.validators.constraints.UniqueUsername;

import javax.validation.constraints.NotEmpty;

@Data
@UniqueUsername
public class UserDto {

    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
