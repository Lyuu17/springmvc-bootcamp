package net.aspanc.bootcamp.springmvc.validators.validators;

import net.aspanc.bootcamp.springmvc.dtos.UserDto;
import net.aspanc.bootcamp.springmvc.services.UserService;
import net.aspanc.bootcamp.springmvc.validators.constraints.UniqueUsername;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, UserDto> {

    @Resource
    private UserService userService;

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext ctx) {
        return userService.findFirstByUsername(userDto.getUsername())
                .filter(userFound -> !Objects.equals(userFound.getId(), userDto.getId()))
                .isEmpty();
    }
}

