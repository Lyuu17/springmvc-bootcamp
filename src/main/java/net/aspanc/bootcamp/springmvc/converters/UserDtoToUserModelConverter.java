package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.UserDto;
import net.aspanc.bootcamp.springmvc.entities.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserDtoToUserModelConverter implements Converter<UserDto, UserModel> {

    @Override
    public UserModel convert(UserDto dto) {
        Assert.notNull(dto, "UserDto can't be null");

        UserModel model = new UserModel();

        model.setId(dto.getId());
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        model.setRole("REGISTERED");
        model.setEnabled(true);

        return model;
    }
}
