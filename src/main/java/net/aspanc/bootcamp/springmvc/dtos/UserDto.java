package net.aspanc.bootcamp.springmvc.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {

    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
