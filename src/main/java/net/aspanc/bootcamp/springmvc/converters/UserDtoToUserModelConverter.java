package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.UserDto;
import net.aspanc.bootcamp.springmvc.entities.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@Component
public class UserDtoToUserModelConverter implements Converter<UserDto, UserModel> {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel convert(UserDto dto) {
        Assert.notNull(dto, "UserDto can't be null");

        UserModel model = new UserModel();

        model.setId(dto.getId());
        model.setUsername(dto.getUsername());
        model.setPassword(passwordEncoder.encode(dto.getPassword()));
        model.setRole("REGISTERED");
        model.setEnabled(true);

        return model;
    }
}
