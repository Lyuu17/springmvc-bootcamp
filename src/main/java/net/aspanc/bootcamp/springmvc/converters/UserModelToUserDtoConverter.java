package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.UserDto;
import net.aspanc.bootcamp.springmvc.entities.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserModelToUserDtoConverter implements Converter<UserModel, UserDto> {

    @Override
    public UserDto convert(UserModel model) {
        Assert.notNull(model, "UserModel can't be null");

        UserDto dto = new UserDto();

        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());

        return dto;
    }
}
